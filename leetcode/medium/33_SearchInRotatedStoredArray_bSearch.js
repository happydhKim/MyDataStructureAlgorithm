/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

 var search = function(nums, target) {
  if (nums.length === 0) return -1;

  let startIndex = 0;
  let endIndex = nums.length - 1;

  while (startIndex <= endIndex) {
    const middleIndex = startIndex + Math.floor((endIndex - startIndex) / 2);

    if (nums[middleIndex] === target) {
      return middleIndex;
    }
    
    if (nums[startIndex] <= nums[middleIndex]) {
      nums[startIndex] <= target && target < nums[middleIndex]
        ? endIndex = middleIndex - 1
        : startIndex = middleIndex + 1;
    } else {
      nums[middleIndex] < target && target <= nums[endIndex]
        ? startIndex = middleIndex + 1
        : endIndex = middleIndex - 1
    }
  }

  return -1;
};

console.log(search([4,5,6,7,0,1,2], 0)); // 4
console.log(search([4,5,6,7,0,1,2], 3)); // -1
console.log(search([1], 0)); // -1
console.log(search([1, 3], 1)); // -1

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

// Example 3:
// Input: nums = [1], target = 0
// Output: -1