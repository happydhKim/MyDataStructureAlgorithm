function solution(s) {
  const getMiddleValue = (string) => string.length / 2;
  
  return s.length % 2 === 1 
    ? s.substr(getMiddleValue(s), 1) 
    : s.substr(getMiddleValue(s) - 1, 2);
}
