//https://www.acmicpc.net/problem/15650
let input = require('fs').readFileSync('/dev/stdin').toString().trim().split(' ');

let N = +(input[0].trim());
let M = +(input[1].trim());
let array = [];

const combination =(index, start, n, m) => {
  if (index == m) {
    console.log(array.join(' '));
    return
  }

  for (let i = start; i <= n; i++) {
    array[index] = i;
    combination(index + 1, i + 1, n, m);
  }
};

combination(0, 1, N, M);
console.log(combination(0, 1, 4 ,2));