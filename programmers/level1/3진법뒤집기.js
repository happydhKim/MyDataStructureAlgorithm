function solution(n) {
  const ternaryReverse = [...n.toString(3)].reverse().join('');
  
  return parseInt(ternaryReverse, 3);
}