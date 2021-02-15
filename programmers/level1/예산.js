function solution(d, budget) {
  let sum = 0;
  let answer = 0;

  d.sort((a, b) => a - b);

  for(let i = 0; i < d.length; i++) {
    answer++;
    sum += d[i];
    
    if (sum > budget) {
      answer--;
      break;
    }
  }

  return answer;
}