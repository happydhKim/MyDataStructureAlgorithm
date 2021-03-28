function binarySearch (target, dataArray) {
  let low = 0;
  let high = dataArray.length - 1;
  
  while (low <= high) {
    let mid = Math.floor((high + low) / 2);
    let guess = dataArray[mid];
    if (guess === target) {
      return guess;
    } else if (guess > target) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  
  return undefined;
}
  
console.log(binarySearch(8, [1,2,3,4,5,6,7,8,9,10,11,12]));