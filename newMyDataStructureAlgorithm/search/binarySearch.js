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
  
console.log(binarySearch(8, [1,2,3,4,5,6,7,8,9,10,11,12]));