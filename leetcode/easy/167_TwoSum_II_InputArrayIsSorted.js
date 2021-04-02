/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */

const binarySearch = (sortedArray, target) => {
  let startIndex = 0;
  let endIndex = sortedArray.length - 1;

  while (startIndex < endIndex) {
    const sumIndex = sortedArray[startIndex] + sortedArray[endIndex];
    if (sumIndex === target) {
      return [startIndex + 1, endIndex + 1];
    }
    sumIndex < target
      ? startIndex++
      : endIndex--;
  }
};

var twoSum = function(numbers, target) {
  return binarySearch(numbers, target);
};


console.log(twoSum([2, 7, 11, 15], 9)); // [1, 2]
console.log(twoSum([2, 3, 4], 6));  // [1, 3]
console.log(twoSum([-1, 0], -1));  // [1, 2]
