function solution(arr) {
  if (arr.length === 1) {
    return [-1];
  }

  let min = 99999999999;

  for (let i = 0; i < arr.length; i++) {
    if (min > arr[i]) {
      min = arr[i];
    }
  }
  
  return arr.filter((value) => value !== min);
}