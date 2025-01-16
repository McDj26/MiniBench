# MINIBENCH

MiniBench 是[TestBench](https://github.com/iSEngLab/TestBench)的一个轻量子集，包含 50 个从 TestBench 中精心挑选的函数，并通过 Node.js 重构了测试框架以改善测试效率，用于快速评估 LLM 的单元测试生成能力。

[English Version Documentation](./README.en.md)

## 测试环境 📦

`Node 20.17.0`
`Python 3.11.3`

💡 测试环境不需要保持严格一致

## 安装 📚

克隆仓库

```bash
git clone https://github.com/McDj26/MiniBench.git
```

安装依赖包

```bash
npm i
```

安装依赖库

```bash
pip install javalang
```

下载 java_project

👉[https://drive.google.com/file/d/1syRdGJfvM7ZWlvEwuEBFrYDNrtw-NGzh/view?usp=sharing](https://drive.google.com/file/d/1syRdGJfvM7ZWlvEwuEBFrYDNrtw-NGzh/view?usp=sharing)

## 配置文件 ⚙️

参考`.env.example`中的内容，创建一个`.env`文件，下面是各个配置项的说明：

| 配置项                    | 说明                               | 默认值                              | 是否必须 |
| ------------------------- | ---------------------------------- | ----------------------------------- | -------- |
| filtered_result_directory | 过滤结果保存路径（数据集保存路径） | ./filter_stage/filtered_result.json | ✔️       |
| OPENAI_API_KEY            | API Key                            | -                                   | ✔️       |
| OPENAI_BASE_URL           | API Base Url                       | -                                   | ✔️       |
| OPENAI_MODEL              | 待测试模型名称                     | -                                   | ✔️       |
| generate_count            | 每个函数生成的单元测试数量         | 5                                   | ✔️       |
| testcases_directory       | 生成的单元测试保存路径             | ./generate_stage                    | ✔️       |
| java_project              | 执行测试的项目集合路径             | ./java_project                      | ✔️       |
| raw_files_directory       | 原始数据集                         | ./source_files                      | ❌       |
| extracted_files_directory | 粗略抽取的数据集保存路径           | ./extract_stage                     | ❌       |
| filter_record_directory   | 过滤记录保存路径                   | ./filter_stage/filter_records.json  | ❌       |
| verbose                   | 是否打印详细过程                   | false                               | ❌       |
| use_repair                | 是否使用修复后的单元测试           | true                                | ❌       |

## 预设命令 🧰

生成单元测试

```bash
npm run generate
```

修复单元测试

```bash
npm run repair
```

执行测试

```bash
npm run benchmark
```

测试结果保存路径：

- `${testcases_directory}/${OPENAI_MODEL}[-repair]/metrics.json`
- `${testcases_directory}/${OPENAI_MODEL}[-repair]/test_record.json`
