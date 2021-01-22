function solution(a, b) {
  let answer = 0;
  const largerNumber = a > b ? a : b;
  let smallerNumber = a < b ? a : b;

  for (let index = smallerNumber; index <= largerNumber; index++) {
    answer += smallerNumber++;
  }

  return answer;
}

console.log(solution(-3, 4))