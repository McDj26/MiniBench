# MINIBENCH

MiniBench is a lightweight subset of [TestBench](https://github.com/iSEngLab/TestBench), comprising 50 carefully selected functions from TestBench. The testing framework has been re-engineered using Node.js to enhance testing efficiency, serving for the rapid evaluation of LLM's unit test generation capability.

## Testing Environment 📦

`Node 20.17.0`
`Python 3.11.3`

💡 The testing environment does not need to be strictly identical.

## Installation 📚

Clone the repository

```bash
git clone https://github.com/McDj26/MiniBench.git
```

Install dependencies

```bash
npm i
```

Install dependency libraries

```bash
pip install javalang
```

Download java_project

👉[https://drive.google.com/file/d/1syRdGJfvM7ZWlvEwuEBFrYDNrtw-NGzh/view?usp=sharing](https://drive.google.com/file/d/1syRdGJfvM7ZWlvEwuEBFrYDNrtw-NGzh/view?usp=sharing)

## Configuration File ⚙️

Refer to the content in `.env.example` and create an `.env` file. Below are explanations for each configuration item:

| Configuration Item        | Description                                      | Default Value                       | Required |
| ------------------------- | ------------------------------------------------ | ----------------------------------- | -------- |
| filtered_result_directory | Path to save filtered results                    | ./filter_stage/filtered_result.json | ✔️       |
| OPENAI_API_KEY            | API Key                                          | -                                   | ✔️       |
| OPENAI_BASE_URL           | API Base Url                                     | -                                   | ✔️       |
| OPENAI_MODEL              | Name of the model to be tested                   | -                                   | ✔️       |
| generate_count            | Number of unit tests to generate per function    | 5                                   | ✔️       |
| testcases_directory       | Directory to save generated unit tests           | ./generate_stage                    | ✔️       |
| java_project              | Path to the collection of projects for execution | ./java_project                      | ✔️       |
| raw_files_directory       | Raw dataset                                      | ./source_files                      | ❌       |
| extracted_files_directory | Directory to save roughly extracted dataset      | ./extract_stage                     | ❌       |
| filter_record_directory   | Directory to save filtering records              | ./filter_stage/filter_records.json  | ❌       |
| verbose                   | Whether to print detailed processes              | false                               | ❌       |
| use_repair                | Whether to use repaired unit tests               | true                                | ❌       |

## Preset Commands 🧰

Generate unit tests

```bash
npm run generate
```

Repair unit tests

```bash
npm run repair
```

Run tests

```bash
npm run benchmark
```

The path to where test results are saved:

- `${testcases_directory}/${OPENAI_MODEL}[-repair]/metrics.json`
- `${testcases_directory}/${OPENAI_MODEL}[-repair]/test_record.json`
