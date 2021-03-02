//https://www.acmicpc.net/problem/15652
const [N, M] = require('fs').readFileSync('dev/stdin').toString().split(' ').map(x => +x);

let array = [];
let output = '';

const dfs = (depth, index) => {
  if(depth === M){
    output += array.join(' ') + '\n';

    return;
  }

  for(let i = index; i < N + 1; i++){
    array.push(i);
    dfs(depth + 1, i);
    array.pop(i);
  }
}

dfs(0, 1);
console.log(output);