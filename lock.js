module.exports = class Lock {
  constructor() {
    this.registry = new Map();
  }
  lock(key) {
    if (!this.registry.has(key)) {
      this.registry.set(key, []);
    }
    const p = new Promise((resolve) => {
      this.registry.get(key).push(resolve);
    });
    if (this.registry.get(key).length === 1) {
      this.registry.get(key)[0]();
    }
    return p;
  }
  unlock(key) {
    if (this.registry.has(key)) {
      this.registry.get(key).shift();
      if (this.registry.get(key).length !== 0) {
        this.registry.get(key)[0]();
      } else {
        this.registry.delete(key);
      }
    }
  }
};
