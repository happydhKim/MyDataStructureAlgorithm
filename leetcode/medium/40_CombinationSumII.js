/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
  candidates.sort((a, b) => (a - b));
  let result = [];
  let check = new Array(candidates.length).fill(false);
      
  const dfs = (current, currentSum, startIndex, check) => {
    if(currentSum == target) {
      result.push(current);
      return;
    }
    if (currentSum > target) {
      return;
    }
    
    for (let i = startIndex; i < candidates.length; i++) {
      if(i > 0 && candidates[i] == candidates[i - 1] && !check[i - 1]) {
        continue;
      }
      check[i] = true;
      dfs(current.concat(candidates[i]), currentSum + candidates[i], i + 1, check);
      check[i] = false;
    }
  };
  
  dfs([], 0, 0, check);

  return result;
};

console.log(combinationSum2([10,1,2,7,6,1,5], 8));
console.log(combinationSum2([2,5,2,1,2], 5));


// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]