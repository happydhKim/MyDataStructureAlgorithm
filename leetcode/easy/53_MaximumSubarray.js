/**
 * @param {number[]} nums
 * @return {number}
 */

var maxSubArray = function(nums) {
  let answer = -999999;

  const dfs = (
    index,
    continueous,
    sum,
  ) => {
    if (continueous) {
      sum > answer ? answer = sum : null;
    }
  
    if(!continueous && index + 1 < nums.length) {
      dfs(index + 1, false, 0);
      dfs(index + 1, true, nums[index + 1]);
    }
    if(continueous && index + 1 < nums.length) {
      dfs(index + 1, true, sum + nums[index + 1]);
    }
  };

  dfs(0, false, 0);
  dfs(0, true, nums[0]);

  return answer;
};

console.log(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]));
console.log(maxSubArray([-1]));
console.log(maxSubArray([5,4,-1,7,8]));

// Example 1 : Input : [-2,1,-3,4,-1,2,1,-5,4] -> Output : 6