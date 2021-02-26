// https://www.acmicpc.net/problem/15650
const [N, M] = require('fs').readFileSync('dev/stdin').toString().split(' ').map(x => +x);

let array = [];
let output = '';

const dfs = (depth, index) => {
  if(array.length === M){
    output += array.join(' ') + '\n';

    return;
  }

  for(let i = index; i <= N; i++){
    array.push(i);
    dfs(depth + 1, i + 1);
    array.pop();
  }
}

dfs(0, 1);
console.log(output);