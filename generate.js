const openAI = require("openai");
const fs = require("fs");
const path = require("path");
const TaskManager = require("./TaskManager");
require("dotenv").config();
const logging = require("./logging");

let testcase_array = [];
const output_directory = path.join(
  __dirname,
  process.env.testcases_directory,
  process.env.OPENAI_MODEL
);
const generate_record_directory = path.join(
  output_directory,
  "generate_record.json"
);
const failed_record_directory = path.join(
  output_directory,
  "failed_record.json"
);
if (!fs.existsSync(output_directory)) {
  fs.mkdirSync(output_directory, { recursive: true });
}
try {
  testcase_array = JSON.parse(
    fs.readFileSync(
      path.join(__dirname, process.env.filtered_result_directory),
      { encoding: "utf-8" }
    )
  );
} catch (err) {
  logging.error(err.message);
  process.exit(1);
}

let generate_record = new Set();
try {
  const input = JSON.parse(
    fs.readFileSync(generate_record_directory, { encoding: "utf-8" })
  );
  generate_record = new Set(input);
} catch (_) {}

const failed_records = [];
process.on("exit", () => {
  logging.info("Saving generate records...");
  const output = [];
  generate_record.forEach((value) => {
    output.push(value);
  });
  fs.writeFileSync(generate_record_directory, JSON.stringify(output, null, 2));
  fs.writeFileSync(
    failed_record_directory,
    JSON.stringify(failed_records, null, 2)
  );
});

testcase_array = testcase_array.filter((testcase) => {
  return !generate_record.has(
    `${testcase.relative_path}-${testcase.method_name}`
  );
});

const openai = new openAI({
  apiKey: process.env.OPENAI_API_KEY,
  baseUrl: process.env.OPENAI_BASE_URL,
});
const model = process.env.OPENAI_MODEL;

async function chat(messages) {
  try {
    const completion = await openai.chat.completions.create({
      messages,
      model,
    });
    if (completion.error) {
      logging.error(completion.error.message);
      return "";
    } else return completion.choices[0].message.content;
  } catch (err) {
    logging.error(err.message);
    return "";
  }
}

const prompt = (extracted_data) =>
  `Below is an instruction that describes a task. Write a response that appropriately completes the request.
### Instruction:
Write a unit test for the following Java Source Code with junit. The context is given.
Unit test has been finished partially. Please complete the section contains <FILL> tag and output the whole test case. Do not add any comments.
If you need more information, please reply "more".

### JAVA Source Code:
${extracted_data.docstring}
${extracted_data.source_code}

### Context:
${extracted_data.context}

### JUNIT Test case:
package ${extracted_data.package};
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class ${extracted_data.class_name}Test {
    @Test
    public void ${extracted_data.method_name}Test() {
        // <FILL>
    }
}

### Response:`;

const controller = new TaskManager(1);
const total_count = testcase_array.length;
const generate_count = parseInt(process.env.generate_count);
let finished_count = 0;
logging.verbose.info(`0/${total_count}`);

controller
  .mapTasks(testcase_array, async (testcase) => {
    const target_directory = path.join(
      output_directory,
      testcase.project_name,
      testcase.class_name
    );

    for (let index = 1; index <= generate_count; index++) {
      const result = await chat([{ role: "user", content: prompt(testcase) }]);
      if (result === "more") {
        failed_records.push({
          msg: "More information needed",
          source_code: testcase,
        });
      } else if (result === "") {
        failed_records.push({
          msg: "Failed to generate test",
          source_code: testcase,
        });
      } else {
        if (!fs.existsSync(target_directory))
          fs.mkdirSync(target_directory, { recursive: true });
        fs.writeFileSync(
          path.join(
            target_directory,
            `${testcase.class_name}Test_${index}.java`
          ),
          result
        );
      }
    }

    fs.writeFileSync(
      path.join(target_directory, "info.json"),
      JSON.stringify(testcase)
    );
    generate_record.add(`${testcase.relative_path}-${testcase.method_name}`);
    logging.verbose.info(`${++finished_count}/${total_count}`);
  })
  .then(
    () => {
      logging.success("All tasks completed");
    },
    (err) => {
      logging.error(err.message);
    }
  );
