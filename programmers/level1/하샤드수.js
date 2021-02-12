function solution(x) {
  return x % x.toString().split('').reduce((previous, current) => +previous + +current) === 0;
}
