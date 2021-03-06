/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

const binarySearch = (sortedArray, target) => {
  let startIndex = 0;
  let endIndex = sortedArray.length - 1;

  while (startIndex <= endIndex) {
    const middleIndex = Math.floor((startIndex + endIndex) / 2);
    const nextTarget = sortedArray[middleIndex];

    if (nextTarget === target) {
      return middleIndex;
    }
    nextTarget < target
      ? startIndex = middleIndex + 1
      : endIndex = middleIndex - 1;
  }

  return startIndex;
};

var searchInsert = function(nums, target) {
  return binarySearch(nums, target);
};


console.log(searchInsert([1,3,5,6], 5));
console.log(searchInsert([1,3,5,6], 2));
console.log(searchInsert([1,3,5,6], 7));
console.log(searchInsert([1,3,5,6], 0));
console.log(searchInsert([1], 0));
console.log(searchInsert([1, 3], 2)); // 1번 틀림 
console.log(searchInsert([1, 3, 5], 1)); // 2번 틀림 
console.log(searchInsert([1, 5, 6, 8, 9, 10], 1)); // 3번 틀림 

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
