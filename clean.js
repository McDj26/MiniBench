const fs = require("fs");
const path = require("path");
const TaskManager = require("./TaskManager");
require("dotenv").config();
const logging = require("./logging");

const java_project_directory = path.join(__dirname, process.env.java_project);
const repair_enabled = process.env.use_repair === "true";
const testcase_directory = path.join(
  __dirname,
  process.env.testcases_directory,
  repair_enabled
    ? `${process.env.OPENAI_MODEL}-repair`
    : process.env.OPENAI_MODEL,
  "generate_record.json"
);
const testcase_paths = JSON.parse(
  fs.readFileSync(testcase_directory, { encoding: "utf8" })
).map((testcase_path) =>
  path.join(
    java_project_directory,
    testcase_path
      .replace(/(.*)-.*$/, "$1")
      .replace(/main/i, "test")
      .replace(/(.*).java$/, "$1Test.java")
  )
);

logging.info("Cleaning testcases...");
let count = 0;
const controller = new TaskManager();
controller
  .mapTasks(testcase_paths, (testcase_path) => {
    logging.verbose.info(`Cleaning ${testcase_path}`);
    return new Promise((resolve) => {
      if (fs.existsSync(testcase_path) && fs.statSync(testcase_path).isFile())
        fs.rm(testcase_path, (err) => {
          if (!err) count++;
          resolve();
        });
      else resolve();
    });
  })
  .then(() => {
    logging.success(`Cleaned ${count} testcases.`);
  });
