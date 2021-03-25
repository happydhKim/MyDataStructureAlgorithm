/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  const map = {};

  for (let i = 0; i < nums.length - 1; i++) {
    map[target - nums[i]] = i;
    if (nums[i + 1] in map) {
      return [map[nums[i + 1]], i + 1];
    } 
  }
}


console.log(twoSum([1,2,3], 3));