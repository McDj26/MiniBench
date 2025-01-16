const fs = require("fs");
const path = require("path");
const logging = require("./logging");
require("dotenv").config();

const directoryPath = path.join(__dirname, process.env.raw_files_directory);
const outputPath = path.join(__dirname, process.env.extracted_files_directory);

const method_blacklist = [/^print/gi, /^set/gi, /hashcode/gi, /createApp/gi];
const project_blacklist = [/cv/gi, /jeecg-boot/gi];
const extract_fields = [
  "project_name",
  "relative_path",
  "file_name",
  "package",
  "class_name",
  "method_name",
  "source_code",
  "simple_context",
  "docstring",
];

if (!fs.existsSync(outputPath)) fs.mkdirSync(outputPath);
else {
  //clean the directory
  fs.readdir(outputPath, (err, files) => {
    if (err) {
      return logging.error("Unable to scan directory: " + err.message);
    }

    files.forEach((file) => {
      fs.unlink(path.join(outputPath, file), (err) => {
        if (err) {
          return logging.error("Unable to delete file: " + err.message);
        }
      });
    });
    logging.info("output directory cleaned");
  });
}

fs.readdir(directoryPath, (err, files) => {
  if (err) {
    return logging.error("Unable to scan directory: " + err.message);
  }

  project_blacklist.forEach((regex) => {
    files = files.filter((file) => {
      return !regex.test(file);
    });
  });

  files.forEach((file) => {
    if (path.extname(file) === ".json") {
      const filePath = path.join(directoryPath, file);
      fs.readFile(filePath, "utf8", (err, data) => {
        if (err) {
          return logging.error("Unable to read file: " + err.message);
        }

        const jsonArray = JSON.parse(data);
        let extractedArray = jsonArray.map((json) => {
          const extracted = {};
          extract_fields.forEach((field) => {
            if (field.includes("context")) {
              extracted["context"] = json[field]
                .replace(/\n{2,}/g, "\n")
                .trim();
            } else {
              extracted[field] = json[field]?.replace(/\n{2,}/g, "\n").trim();
            }
          });
          return extracted;
        });

        method_blacklist.forEach((regex) => {
          extractedArray = extractedArray.filter((extracted) => {
            return !regex.test(extracted.method_name) && extracted.docstring;
          });
        });

        const file_path = path.join(outputPath, file);

        fs.writeFile(
          file_path,
          JSON.stringify(extractedArray, null, 2),
          "utf8",
          (err) => {
            if (err) {
              logging.error("Unable to write file: " + err.message);
            } else {
              logging.success(
                `${file_path} is written successfully. Length: ${extractedArray.length}`
              );
            }
          }
        );
      });
    }
  });
});
