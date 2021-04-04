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

    if (nextTarget.number === target) {
      return nextTarget.index;
    }
    nextTarget.number < target
      ? startIndex++
      : endIndex--;
  }

  return -1;
};

const setSortedNumber = (nums) => {
  return nums.map((number, index) => {
    return {number, index}
  }).sort((a, b) => a.number - b.number);
}

var search = function(nums, target) {
  const sortedNums = setSortedNumber(nums);
  return binarySearch(sortedNums, target);
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