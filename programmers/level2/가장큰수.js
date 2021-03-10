function solution(numbers) {
  const checkDetail = (bigNumber, smallNumber) => {
    for (let i = 0; i < bigNumber.length; i++) {
      if(bigNumber[i] > smallNumber) {
        return [smallNumber, bigNumber[i]];
      }
    }

    return false;
  };

  numbers.sort((a, b) => {
    const firstValue = a.toString();
    const secondValue = b.toString();
    if (firstValue.length === secondValue.length) {
      return secondValue - firstValue;  
    } else if (firstValue.length > secondValue.length) {
      const result = checkDetail(firstValue, secondValue);
      if (result) {
        return result[0] - result[1];
      }
    } else if (firstValue.length < secondValue.length) {
      const result = checkDetail(secondValue, firstValue);
      if (result) {
        return result[0] - result[1];
      }
    }
    
    return secondValue[0] - firstValue[0];
  });

  return numbers.join('');
}


function solution2(numbers) {
  let answer = '';

  const sortedNumbers = numbers.map((value) => value + '').sort((a, b) => (b + a) - (a + b));
  sortedNumbers[0] === '0' ? answer += 0 : answer = sortedNumbers.join('');

  return answer;
}

// console.log(solution([6, 10, 2]));
// console.log(solution([3, 30, 34, 5, 9]));
// console.log(solution([9, 8, 96, 99, 92]));
// [6, 10, 2]	"6210"
// [3, 30, 34, 5, 9]	"9534330"