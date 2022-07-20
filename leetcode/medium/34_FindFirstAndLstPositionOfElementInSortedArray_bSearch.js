/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  const MAX_LENGTH = nums.length - 1;
  
  let answer = [-1, -1];
  let leftIndex = 0;
  let rightIndex = MAX_LENGTH;
  
  while (leftIndex <= rightIndex) {
    const middleIndex = leftIndex + Math.floor((rightIndex - leftIndex) / 2);
    if (nums[middleIndex] === target) {
      answer[0] = answer[1] = middleIndex;
      while (nums[answer[0] - 1] === target) {
        answer[0]--;
      }
      while (nums[answer[1] + 1] === target) {
        answer[1]++;
      }
      return answer;
    }

    if (nums[middleIndex] > target) {
      rightIndex = middleIndex - 1;
    }
    if (nums[middleIndex] < target) {
      leftIndex = middleIndex + 1;
    }
  }

  return answer;
};

console.log(searchRange([5,7,7,8,8,10], 8));
console.log(searchRange([5,7,7,8,8,10], 6));
console.log(searchRange([], 0));
console.log(searchRange([0, 0], 0));

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Input: nums = [], target = 0
// Output: [-1,-1]