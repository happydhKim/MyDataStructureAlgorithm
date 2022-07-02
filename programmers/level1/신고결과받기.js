// https://programmers.co.kr/learn/courses/30/lessons/92334?language=javascript

function solution(id_list, report, k) {
  let reports = [...new Set(report)].map(a => a.split(' '));
  let counts = new Map();

  for (const reported of reports){
    counts.set(reported[1], counts.get(reported[1]) + 1 || 1);
  }

  let idList = new Map();
  for (const report of reports) {
    if(counts.get(report[1]) >= k){
      idList.set(report[0],idList.get(report[0])+1 || 1);
    }
  }
  let answer = id_list.map(a => idList.get(a) || 0)

  return answer;
}