function solution(n) {
  return n.toString().split('').reduce((accumulator, currentValue) => accumulator + +currentValue, 0);
}
