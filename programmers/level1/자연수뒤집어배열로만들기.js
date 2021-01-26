function solution(n) {
  return (n + '').split('').reverse().map((value) => parseInt(value));
}