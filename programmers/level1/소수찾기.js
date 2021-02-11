// 에라토스테네스의 체

function solution(n) {
  let arr = [];
  for (let i = 1; i <= n; i++) {
    arr.push(i);
  }
  for (let i = 1; i * i < n; i++) {
    if(arr[i]) {
      let number = arr[i];
      for (let j = number * number; j <= n; j += number) {
        arr[j - 1] = 0;        
      }
    }
  }

  let answer = arr.filter((number) => number);
  answer.shift();
  
  return answer.length;
}