function solution(number, k) {
  let stack = [];
  
  for (let i = 0; i < number.length; i++) {
    let currentValue = number[i];
    while (k > 0 && stack[stack.length - 1] < currentValue) {
      stack.pop();
      k--;
    }
    stack.push(currentValue);
  }

  stack.splice(stack.length - k, k);
  
  return stack.join('');
}