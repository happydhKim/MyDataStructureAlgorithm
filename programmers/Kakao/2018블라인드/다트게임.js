function solution(dartResult) {
  let stack = [];
  let score = { S: 1, D: 2, T: 3 };
  let count = 0;
  const len = dartResult.length;

  for (let i = 0; i < len; i++) {
    let data = dartResult.charAt(i);
    if (+data != data) {
      if (score[data]) {
        stack.push(Math.pow(dartResult.slice(i - count, i), score[data]));
        count = 0;
      } else {
        const invariable = data === '*' ? 2 : -1;
        const len = stack.length;
        if (invariable == 2 && len > 1) {
          stack[len - 2] = stack[len - 2] * invariable;
        }
        stack[len - 1] = stack[len - 1] * invariable;
      }
    } else {
      count++;
    }
  }

  return stack.reduce((acc, value) => acc + value, 0);
}