function solution(N, stages) {
  let answer = [];
  let stageCount = new Array(N + 1).fill(0);
  let players = stages.length;

  for (let i = 0; i < stages.length; i++) {
    stageCount[stages[i] - 1]++;
  }

  for (let i = 0; i < N; i++) {
    answer.push({index: i + 1, calc: stageCount[i] / players});
    players -= stageCount[i];
  }

  return answer.sort((a, b) => b.calc - a.calc).map((value) => value.index);
}

console.log(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]));
