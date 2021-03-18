function solution(numbers) {
  let primeNumbers = [];

  const checkPrime = (num) => {
    let count = 0;
    for (let i = 1; i <= num; i++) {
      if (num % i === 0) {
        count++;
      }
      if (count >= 3) {
        break;
      }
    }
    if (count === 2 && !primeNumbers.includes(num)) {
      primeNumbers.push(num);
    }
  };

  const dfs = (arr, str) => {
    console.log(arr, str);
    if (arr.length > 0) {
      for (let i = 0; i < arr.length; i++) {
        const temp = [...arr];
        temp.splice(i, 1);
        mergeNumbers(temp, str + arr[i]);
      }
    }

    if (str.length > 0) {
      checkPrime(+str);
    }
  };

  dfs(numbers.split(''), '');

  return primeNumbers.length;
}

console.log(solution('17'));
console.log(solution('011'));