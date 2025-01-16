const fs = require("fs");
const path = require("path");
const TaskManager = require("./TaskManager");
require("dotenv").config();
const logging = require("./logging");

const input_directory = path.join(
  __dirname,
  process.env.testcases_directory,
  process.env.OPENAI_MODEL
);
const output_directory = path.join(
  __dirname,
  process.env.testcases_directory,
  `${process.env.OPENAI_MODEL}-repair`
);

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
      "npm run generate"
    )} first?`
  );
  process.exit(1);
}

const controller = new TaskManager(5);

const input_record = [];
const collect_file_paths = (directory) =>
  controller.mapTasks(
    fs.readdirSync(directory),
    (file) =>
      new Promise((resolve) => {
        const filepath = path.join(directory, file);
        fs.stat(filepath, (err, stats) => {
          if (err) {
            logging.error("Unable to scan directory: " + err.message);
            resolve();
          } else {
            if (stats.isDirectory()) {
              collect_file_paths(filepath).then(resolve);
            } else {
              input_record.push(filepath);
              resolve();
            }
          }
        });
      })
  );

const repair = (code) =>
  code
    .replace(/.*```java/s, "")
    .replace(/```.*$/s, "")
    .trim();

logging.info("Repairing testcases...");
collect_file_paths(input_directory)
  .then(() => {
    controller.mapTasks(
      input_record,
      (filepath) =>
        new Promise((resolve) => {
          logging.verbose.info(`Repairing ${filepath}`);
          const output_path = filepath.replace(
            input_directory,
            output_directory
          );
          const directory = path.dirname(output_path);
          if (!fs.existsSync(directory)) {
            fs.mkdirSync(directory, { recursive: true });
          }
          fs.writeFile(
            output_path,
            path.extname(filepath) === ".java"
              ? repair(fs.readFileSync(filepath, "utf8"))
              : fs.readFileSync(filepath, "utf8"),
            resolve
          );
        })
    );
  })
  .then(() => {
    logging.success("Repair finished!");
  });
