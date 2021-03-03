// https://www.acmicpc.net/problem/15654
const input = require('fs').readFileSync('dev/stdin').toString().split(' ').map(x => +x);

let [given,nums] = [input[0],input[1].sort((a,b) => a - b)]
let [N, M] = given.map(e => Number(e))

let check = new Array(N).fill(false);
let output = [];

const dfs = (array) => {
  if(array.length === M){
    output.push(arr.join(' '));

    return;
  }

  for(let i = 0; i < N; i++) {
    if (!check[i]) {
      check[i] = true;
      array.push(nums[i]);
      dfs(array);
      array.pop(i);
      check[i] = false;
    }
  }
}

dfs([]);
console.log(output.join('\n'));