function solution(priorities, location) {
  const paper = priorities.map((value, index) => ({ priorities: value, location: index}));
  const result = [];

  while(paper.length) {
    const priority = paper.findIndex(p => p.priorities > paper[0].priorities);
    priority === -1 ? result.push(paper.shift()) : paper.push(paper.shift());
  }

  return result.findIndex(p => p.location === location) + 1;
}