/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  let result = [];
  nums.sort((a, b) => a - b);
  let visited = new Array(nums.length).fill(false);
  
  const backtrack = (permutations) => {
    if (permutations.length === nums.length) {
      result.push([...permutations]);
    } else {
      for (let i = 0; i < nums.length; i++) {
        if (visited[i] || (i > 0 && nums[i] === nums[i - 1] && !visited[i - 1])) continue;
        visited[i] = true;
        permutations.push(nums[i]);
        backtrack(permutations);
        visited[i] = false;
        permutations.pop();
      }
    }
  };
  
  backtrack([]);
  return result;
};


console.log(permuteUnique([1,1,2]));
console.log(permuteUnique([1,2,3]));

// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]