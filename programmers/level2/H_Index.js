function solution(citations) {
  let answer = 0;

  citations.sort((a, b) => b - a); 

  while(answer <= citations.length) {
    if (answer + 1 <= citations[answer]) {
      answer++;   
    } else {
      break;
    }
  }

  return answer;
}