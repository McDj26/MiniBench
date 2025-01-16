const colors = require("colors-console");

const INF_PREFIX = colors("blue", "[INFO]    ");
const ERR_PREFIX = colors("red", "[ERROR]   ");
const WRN_PREFIX = colors("yellow", "[WARNING] ");
const SUC_PREFIX = colors("green", "[SUCCESS] ");

let logging = {
  info: (message) => {
    console.log(INF_PREFIX + message);
  },
  error: (message) => {
    console.error(ERR_PREFIX + message);
  },
  warn: (message) => {
    console.log(WRN_PREFIX + message);
  },
  success: (message) => {
    console.log(SUC_PREFIX + message);
  },
};

const blackhole = new Proxy(
  {},
  {
    get: () => () => {},
  }
);

const isVerbose = /true/i.test(process.env.verbose || "");

logging = new Proxy(logging, {
  get: (target, name) => {
    return name === "verbose" ? (isVerbose ? target : blackhole) : target[name];
  },
});

module.exports = logging;
