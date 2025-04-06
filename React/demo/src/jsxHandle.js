/*
Encapsulates an object iteration method
- for/in loop. will iterate obver public & private properties,
  Only enumerable, non-symbol properties can be iterated.

  Object.getOwnPropertyNames(arr) -> Get non-symbol private properties
  Object.getOwnPropertySymbols(arr) -> Get Symbol private properties
  ES6 Reflect.ownKeys can do the same as above
*/
Array.prototype.BB = 30;
let arr = [10, 20];
arr[Symbol("AA")] = 20;
console.log(arr);

// 0 1 BB
for (let key in arr) {
  console.log(key);
}

// [Symbol(AA)]
console.log(Object.getOwnPropertySymbols(arr));
// ['0', '1', 'length']
console.log(Object.getOwnPropertyNames(arr));
// get all private properties
let keys = Object.getOwnPropertySymbols(arr).concat(
  Object.getOwnPropertyNames(arr)
);
console.log(keys);

const each = function each(obj, callback) {
    if (obj === null || typeof obj !== "object") throw new TypeError('obj is not a object');
    if (typeof callback !== "function") throw new TypeError('callback is not a function');
    let keys = Reflect.ownKeys(arr);
    keys.forEach((key) => {
      let value = obj[key]
      callback(value, key);
    });
}

each(arr,(key,value) => {
    console.log('each function',key, value);
})


