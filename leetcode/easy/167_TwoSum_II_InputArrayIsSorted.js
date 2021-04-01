/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */

const binarySearch = (numbers, target) => {
  const startIndex = 0;
  const endIndex = numbers.length - 1;

  while (startIndex <= endIndex) {
    const middleIndex = startIndex + Math.floor((endIndex - startIndex) / 2);
    const nextTarget = sortedArray[middleIndex];

    if (nextTarget === target) {

      return middleIndex;
    }
    nextTarget < target
      ? startIndex = middleIndex + 1
      : endIndex = middleIndex - 1;
  }

  return -1;
};

var twoSum = function(numbers, target) {
  return target;
};

