/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
 var combinationSum = function(candidates, target) {
  candidates.sort((a, b) => a - b);

  let length = candidates.length;
  let answer = [];

  const search = (index, prefix, target) => {
    if (target === 0) answer.push(prefix.slice());
    if (index === length) return;
    if (target <= 0) return;

    prefix.push(candidates[index]);
    search(index, prefix, target - candidates[index]);
    prefix.pop();
    search(index + 1, prefix, target);
  }

  search(0, [], target);

  return answer;
};


console.log(combinationSum([2,3,6,7], 7));
console.log(combinationSum([2,3,5], 8));
console.log(combinationSum([2], 1));

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]

// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]

// Input: candidates = [2], target = 1
// Output: []