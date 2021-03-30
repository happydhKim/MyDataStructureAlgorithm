/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

const binarySearch = (nums, target) => {
  let lowIndex = 0;
  let highIndex = nums.length - 1;

  if (target < nums[0]) {
    return 0;
  }
  if (target > nums[highIndex]) {
    return highIndex + 1;
  }
  while (lowIndex <= highIndex) {
    let midIndex = Math.floor((highIndex + lowIndex) / 2);
    let pointer = nums[midIndex];

    // if (midIndex !== 0 && pointer < target && target > nums[minIndex - 1]) {
    //   return midIndex;
    // }
    console.log('answer',target,  pointer, nums[midIndex - 1], midIndex);
    if (pointer === target) {
      return midIndex;
    } else if (pointer > target) {
      highIndex = midIndex - 1;
    } else {
      highIndex = midIndex + 1;
    }
  }
};

var searchInsert = function(nums, target) {
  return binarySearch(nums, target);
};


console.log(searchInsert([1,3,5,6], 5));
// console.log(searchInsert([1,3,5,6], 2));
// console.log(searchInsert([1,3,5,6], 7));
// console.log(searchInsert([1,3,5,6], 0));
// console.log(searchInsert([1], 0));

// Example 1:

// Input: nums = [1,3,5,6], target = 5
// Output: 2
// Example 2:

// Input: nums = [1,3,5,6], target = 2
// Output: 1
// Example 3:

// Input: nums = [1,3,5,6], target = 7
// Output: 4
// Example 4:

// Input: nums = [1,3,5,6], target = 0
// Output: 0
// Example 5:

// Input: nums = [1], target = 0
// Output: 0