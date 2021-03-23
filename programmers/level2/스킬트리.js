function solution(skill, skill_trees) {
  let answer = 0;
  let skillArray = skill.split('');

  for (let i = 0; i < skill_trees.length; i++) {
    const checkedString = skill_trees[i]
      .split('')
      .filter(value => skillArray.includes(value))
      .join('');

    if(checkedString === skill.substring(0, checkedString.length)) {
      answer++;
    }
  }

  return answer;
}

console.log(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]));