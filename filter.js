const fs = require("fs");
const path = require("path");
const readline = require("readline");
const logging = require("./logging");
const colors = require("colors-console");
require("dotenv").config();

const reader = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inputDirectory = path.join(
  __dirname,
  process.env.extracted_files_directory
);

const inputArray = [];
const outputArray = [];
let accept_record = [];
console.clear();
try {
  accept_record = JSON.parse(
    fs.readFileSync(path.join(__dirname, process.env.filter_record_directory), {
      encoding: "utf8",
    })
  );
} catch (_) {}
process.on("exit", () => {
  logging.info("Saving progress...");
  fs.writeFileSync(
    path.join(__dirname, process.env.filter_record_directory),
    JSON.stringify(accept_record, null, 2),
    { encoding: "utf8" }
  );
});
fs.readdir(inputDirectory, (err, files) => {
  if (err) {
    logging.error("Unable to scan directory: " + err.message);
  }

  files.forEach((file) => {
    const filePath = path.join(inputDirectory, file);
    const objectArray = JSON.parse(
      fs.readFileSync(filePath, { encoding: "utf8" })
    );
    inputArray.push(...objectArray);
  });

  if (accept_record.length > 0) {
    logging.info("Resuming from last progress...");
    accept_record.forEach((accept) => {
      if (accept) {
        outputArray.push(inputArray.shift());
      } else {
        inputArray.shift();
      }
    });
  }

  const readNext = () => {
    logging.info(inputArray.length + " items left");

    const data = inputArray.shift();
    if (data) {
      const processed_code = data.source_code
        .replace(/\n{2,}/g, "\n")
        .trim()
        .replace(data.method_name, colors("red", data.method_name));
      const processed_context = data.simple_context
        .replace(/(import|package).*?;/g, "")
        .replace(/\n{2,}/g, "\n")
        .trim()
        .replace(data.method_name, colors("red", data.method_name));
      logging.info("Source code:");
      console.log(processed_code);
      logging.info("Context:");
      console.log(processed_context);

      reader.question("Accept current case?[Y/n]\n", (input) => {
        if (input.toLocaleLowerCase() === "y" || input === "") {
          accept_record.push(true);
          outputArray.push(data);
        } else {
          accept_record.push(false);
        }
        console.clear();
        readNext();
      });
    } else {
      // Process finished
      logging.info("Saving result...");
      fs.writeFileSync(
        path.join(__dirname, process.env.filtered_result_directory),
        JSON.stringify(outputArray, null, 2),
        { encoding: "utf8" }
      );
      reader.close();
      logging.success("All items processed");
    }
  };
  readNext();
});
