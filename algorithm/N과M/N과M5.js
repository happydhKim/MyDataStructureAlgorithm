// https://www.acmicpc.net/problem/15654
let input = require('fs').readFileSync('./dev/stdin').toString().split('\n')

const firstLine = input[0].split(' ').map((vlaue) => (+vlaue));
const secondLine = input[1].split(' ').map((value) => (+value));

const N = firstLine[0];
const M = firstLine[1];
let output = '';

const nums = secondLine.sort((a, b) => (a - b));
const check = new Array(N + 1).fill(false);
const answer = [];

const combination = (depth) => {
  if (depth === M) {
    output = output + answer.join(' ') + '\n';
    return;
  }

  for (let i = 0; i < N; i++) {
    if (!check[i]) {
      check[i] = true;
      answer.push(nums[i]);
      combination(depth+1);
      answer.pop(nums[i]);
      check[i] = false;
    }
  }
};

combination(0)
console.log(output.trim())