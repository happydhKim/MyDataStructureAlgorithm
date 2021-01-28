function solution(numbers) {
  const calcArray = [];

  for (let i = 0; i < numbers.length; i++) {
      for (let j = i + 1; j < numbers.length; j++) {
        calcArray.push(numbers[i] + numbers[j])
      }
  }

  return [...new Set(calcArray)].sort((a, b) => a - b);
}