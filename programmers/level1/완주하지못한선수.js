function solution(participant, completion) {
  participant.sort();
  completion.sort();

  for (let i = 0; i < participant.length; i++) {
    if (participant[i] !== completion[i]) {
      return participant[i];
    }
  }
}

const participant = ['leo', 'kiki', 'eden'];
const completion=	['eden', 'kiki'];
console.log(solution(participant, completion));