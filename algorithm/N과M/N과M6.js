//https://www.acmicpc.net/problem/15655
let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

// 1 2 3 4 5 6 7 8
let check = [];
let N = +(input[0].trim().split(' '))[0]
let M = +(input[0].trim().split(' '))[1]
let value = (input[1].trim().split(' '));
let num = [];
let output = [];

for(let i = 0; i < value.length; i++){
  let number = value[i];
  num.push(number);
}

num.sort(function (a ,b) {
  return a - b;
});


const dfs = (index, start) => {
  if (index === M) {
    console.log(output.join(" "));

    return
  }

  for (let i = start; i < N; i++) {
    if (!check[i]) {
      check[i] = true;
      output[index] = num[i];
      dfs(index + 1, i + 1);
      check[i] = false;
    }
  }
}

dfs(0, 0);