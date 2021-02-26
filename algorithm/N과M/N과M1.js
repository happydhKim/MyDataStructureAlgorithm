// https://www.acmicpc.net/problem/15649
const [N, M] = require('fs').readFileSync('dev/stdin').toString().split(' ').map(x => + x);

let check = new Array(N).fill(false);
let array = [];
let output = '';

const dfs = (depth) => {
  if(depth >= M){
    output += array.join(' ') + '\n';

    return;
  }
  
  for(let i = 1; i <= N; i++) {
    if (!check[i]) {
      check[i] = true;
      array.push(i);
      dfs(depth + 1);
      array.pop();
      check[i] = false;
    }
  }
}

dfs(0);
console.log(output);