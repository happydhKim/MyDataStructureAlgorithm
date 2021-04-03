/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

const binarySearch = (sortedArray, target) => {
  let startIndex = 0;
  let endIndex = sortedArray.length - 1;

  while (startIndex <= endIndex) {
    const middleIndex = Math.floor((endIndex - startIndex) / 2);
    const nextTarget = sortedArray[middleIndex];

    if (nextTarget === target) {
      return nextTarget;
    }
    nextTarget < target
      ? startIndex++
      : endIndex--;
  }

  return -1;
};

var search = function(nums, target) {
  return binarySearch(nums.sort(), target);
};

console.log(search([4,5,6,7,0,1,2], 0)); // 4
console.log(search([4,5,6,7,0,1,2], 3)); // -1
console.log(search([1], 0)); // -1

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

// Example 3:
// Input: nums = [1], target = 0
// Output: -1