//https://www.acmicpc.net/problem/15651
const [N, M] = require('fs').readFileSync('dev/stdin').toString().split(' ').map(x => +x);

let array = [];
let output = '';

const dfs = (depth) => {
  if(depth === M){
    output += array.join(' ') + '\n';

    return;
  }

  for(let i = 1; i < N + 1; i++){
    array.push(i);
    dfs(depth + 1);
    array.pop(i);
  }
}

dfs(0);
console.log(output);