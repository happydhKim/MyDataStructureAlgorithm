// 첫 번째 풀이
function solution(numbers) {
  return new Array(10).fill(0).map((v, i) => i).filter(v => !numbers.includes(v)).reduce((p, v) => p + v, 0);
}

// 조금 더 나은
function solution(numbers) {
  return 45 - numbers.reduce((cur, acc) => cur + acc, 0);
}

console.log(solution([1,2,3,4,6,7,8,0]));
console.log(solution([5,8,4,0,6,7,9]));