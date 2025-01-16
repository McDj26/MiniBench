const { exec } = require("child_process");
const path = require("path");
const fs = require("fs");
const TaskManager = require("./TaskManager");
const colors = require("colors-console");
require("dotenv").config();
const logging = require("./logging");
const Lock = require("./lock");

const repair_enabled = process.env.use_repair === "true";
logging.info(`Repair ${repair_enabled ? "enabled" : "disabled"}`);

const input_directory = path.join(
  __dirname,
  process.env.testcases_directory,
  repair_enabled
    ? `${process.env.OPENAI_MODEL}-repair`
    : process.env.OPENAI_MODEL
);

// check input directory
if (!fs.existsSync(input_directory)) {
  logging.error(
    `Directory ${colors(
      ["yellow", "underline"],
      input_directory
    )} does not exist.`
  );
  logging.info(
    `Maybe you need to run command ${colors(
      "green",
      "npm run repair"
    )} first? Or you can skip this step by setting use_repair=false in .env.`
  );
  process.exit(1);
} else if (!fs.statSync(input_directory).isDirectory()) {
  logging.error(`${input_directory} is not a directory.`);
  process.exit(1);
}

const async_exec = (command, options) => {
  return new Promise((resolve) => {
    exec(command, options, (_, stdout) => {
      resolve(stdout);
    });
  });
};
const shuffle = (array) => {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
};

// benchmark main function
(async function main() {
  const controller = new TaskManager(5);
  const filtered_test_info = [];
  const java_code_analyzer = path.join(__dirname, "evaluate_java_code.py");
  const java_project_directory = path.join(__dirname, process.env.java_project);

  let metrics = {
    "compile error": 0,
    "syntax error": 0,
    "test error": 0,
    accepted: 0,
  };

  let test_record = [];
  process.on("exit", () => {
    logging.info("Saving progress...");
    fs.writeFileSync(
      path.join(input_directory, "metrics.json"),
      JSON.stringify(metrics)
    );
    fs.writeFileSync(
      path.join(input_directory, "test_record.json"),
      JSON.stringify(test_record)
    );
  });

  // collect testcases
  logging.info("Collecting testcases...");
  let test_info_array = [];
  const visit_directory = (directory) => {
    const files = fs.readdirSync(directory);
    files.forEach((file) => {
      const file_path = path.join(directory, file);
      if (fs.statSync(file_path).isDirectory()) visit_directory(file_path);
    });
    if (files.includes("info.json")) {
      const info = JSON.parse(
        fs.readFileSync(path.join(directory, "info.json"), {
          encoding: "utf8",
        })
      );
      info.relative_path = info.relative_path
        .replace(/main/, "test")
        .replace(/(.*).java$/, "$1Test.java");
      test_info_array.push(
        Object.assign(info, {
          testcases: files
            .filter((file) => file.endsWith(".java"))
            .map((file) => path.join(directory, file)),
        })
      );
    }
  };
  visit_directory(input_directory);

  // Resume from last progress
  if (
    fs.existsSync(path.join(input_directory, "test_record.json")) &&
    fs.existsSync(path.join(input_directory, "metrics.json"))
  ) {
    logging.info("Resuming from last progress...");
    test_record = test_record.concat(
      JSON.parse(
        fs.readFileSync(path.join(input_directory, "test_record.json"), {
          encoding: "utf8",
        })
      )
    );
    const test_record_set = new Set(test_record.map((r) => r.testcase));
    test_info_array.forEach((test_info) => {
      test_info.testcases = test_info.testcases.filter((testcase) => {
        return !test_record_set.has(testcase);
      });
    });
    metrics = JSON.parse(
      fs.readFileSync(path.join(input_directory, "metrics.json"), {
        encoding: "utf8",
      })
    );
  }

  // static analysis
  logging.info("Running static analysis...");
  await controller.mapTasks(test_info_array, async (test_info) => {
    const length = test_info.testcases.length;
    for (let index = 0; index < length; index++) {
      const static_analysis_result = await async_exec(
        `python ${java_code_analyzer} ${test_info.testcases[index]}`
      );
      if (!static_analysis_result.includes("Syntax Error")) {
        filtered_test_info.push({
          target_path: path.join(
            java_project_directory,
            test_info.relative_path
          ),
          project_name: test_info.project_name,
          test_path: path.join(java_project_directory, test_info.project_name),
          class_name: static_analysis_result.trim(),
          testcase_path: test_info.testcases[index],
        });
      } else {
        logging.verbose.info(
          "Static analysis failed on " +
            test_info.testcases[index].replace(/.*\\(\w+.java)/i, "$1")
        );
        metrics["syntax error"] += 1;
        test_record.push({
          msg: "Syntax Error",
          testcase: test_info.testcases[index],
        });
      }
    }
  });

  // run tests
  logging.info("Running tests...");
  shuffle(filtered_test_info);
  const locker = new Lock();
  const total_count = filtered_test_info.length;
  let test_count = 0;
  await controller.mapTasks(filtered_test_info, async (test_info) => {
    await locker.lock(test_info.project_name);
    fs.copyFileSync(test_info.testcase_path, test_info.target_path);
    // test-compile
    logging.verbose.info(`Compiling ${test_info.target_path}`);
    const stdout = await async_exec(
      'mvn clean test-compile "-Drat.skip=true" "-Dsurefire.failIfNoSpecifiedTests=false" "-Dcheckstyle.skip=true"',
      { cwd: test_info.test_path }
    );
    if (stdout.includes("BUILD FAILURE")) {
      logging.verbose.info(
        `Testcase ${colors("red", test_info.class_name)} failed to compile`
      );
      metrics["compile error"] += 1;
      test_record.push({
        msg: "Compile Error",
        testcase: test_info.testcase_path,
      });
      fs.rmSync(test_info.target_path);
      logging.verbose.info(`Progress: ${++test_count}/${total_count}`);
      locker.unlock(test_info.project_name);
      return;
    }

    // run test
    logging.verbose.info(
      `Running testcase ${colors("blue", test_info.class_name)}`
    );
    const test_result = await async_exec(
      `mvn clean test \"-DskipPitest=true\" \"-Drat.skip=true\" \"-Dsurefire.failIfNoSpecifiedTests=false\" \"-Dcheckstyle.skip=true\" \"-Dtest=${test_info.class_name}\"`,
      { cwd: test_info.test_path }
    );

    if (
      test_result.includes("BUILD FAILURE") ||
      /Tests run: (\d+), Failures: (\d+), Errors: (\d+), Skipped: (\d+)/gi.exec(
        test_result
      )[3] !== "0"
    ) {
      logging.verbose.info(
        `Testcase ${colors("red", test_info.class_name)} failed`
      );
      metrics["test error"] += 1;
      test_record.push({
        msg: "Test Error",
        testcase: test_info.testcase_path,
      });
      fs.rmSync(test_info.target_path);
      logging.verbose.info(`Progress: ${++test_count}/${total_count}`);
      locker.unlock(test_info.project_name);
      return;
    }

    logging.verbose.success(
      `Testcase ${colors("green", test_info.class_name)} passed`
    );
    metrics["accepted"] += 1;
    test_record.push({
      msg: "Accepted",
      testcase: test_info.testcase_path,
    });
    fs.rmSync(test_info.target_path);
    logging.verbose.info(`Progress: ${++test_count}/${total_count}`);
    locker.unlock(test_info.project_name);
  });

  // finish
  logging.success("Benchmark finished!");
  logging.info("Metrics:");
  for (const [key, value] of Object.entries(metrics)) {
    logging.info(`${key}: ${value}`);
  }
})();
