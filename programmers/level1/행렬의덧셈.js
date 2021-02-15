function solution(arr1, arr2) {
  return arr1.map((value, index) => value.map((v, i) => v + arr2[index][i]));
}