// 진행중 
function solution(numbers, hand) {
  let answer = '';
  let leftHandPosition = '*';
  let rightHandPosition = '#';

  const getPriorityMove = (number) => {
    if(leftHandPosition === 1 && rightHandPosition === 3 ||
       leftHandPosition === 4 && rightHandPosition === 6 ||
       leftHandPosition === 7 && rightHandPosition === 9 ||
       leftHandPosition === '*' && rightHandPosition === '#') {
      return hand;
    }
    if(number === 2) {
      if(leftHandPosition === '*') return 'right';
      if(rightHandPosition === '#') return 'left';
      return leftHandPosition > rightHandPosition - 2 ? 'left' : 'right';
    } else if(number === 5) {
      
    } else if(number === 8) {

    } else {

    }
  };
  for (let i = 0; i < numbers.length; i++) {
    if(numbers[i] === 1 || numbers[i] === 4 || numbers[i] === 7) {
      answer += 'L';
      leftHandPosition = numbers[i];
    } else if(numbers[i] === 3 || numbers[i] === 6 || numbers[i] === 9) {
      answer += 'R';
      rightHandPosition = numbers[i];
    } else {
      if(getPriorityMove(number[i]) === 'left') {
        answer += 'L';
        leftHandPosition = numbers[i];
      } else {
        answer += 'R';
        rightHandPosition = numbers[i];
      }
    }
  }

  return answer;
}