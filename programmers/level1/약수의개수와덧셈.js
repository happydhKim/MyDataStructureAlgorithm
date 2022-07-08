const getYaksuCount = (num) => {
  let count = 2;
  for (let i = 1; i < num; i++) {
    if (num % i === 0) count++;
  }
  return count;
}

function solution(left, right) {
  let answer = 0;
  for (let i = left; i <= right; i++) {
    if (getYaksuCount(i) % 2 === 0) {
      answer += i;
    }
  }
  return answer;
}
// 13	17	43
// 24	27	52
console.log(solution(13, 17));
console.log(solution(24, 27));


function solution(left, right) {
  var answer = 0;
  for (let i = left; i <= right; i++) {
    if (Number.isInteger(Math.sqrt(i))) {
      answer -= i;
    } else {
      answer += i;
    }
  }
  return answer;
}

// 제곱근이 정수면 약수의 개수가 홀수다... 메모