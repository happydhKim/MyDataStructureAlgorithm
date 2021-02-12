function solution(a, b) {
  return a.reduce((previousValue, currentValue, currentIndex) => {
    return previousValue + currentValue * b[currentIndex];
  }, 0);
}