const checkOverIntegerRange = (x) => x < -2147483647 || x > 2147483647;

/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
  if (checkOverIntegerRange(x)) return 0;
  const reverseString = x.toString().split('').reverse().join('');

  const reverseNumber = reverseString[reverseString.length - 1] === '-'
    ? -reverseString.replace(/-/, '')
    : +reverseString;

  return checkOverIntegerRange(reverseNumber) ? 0 : reverseNumber; // 이거 없어서 틀렸었음 문제 꼼꼼하게 보셈
};


console.log(reverse(123123123123123));
console.log(reverse(123));
console.log(reverse(-123));
console.log(reverse(120));

// Input: x = 123
// Output: 321

// Input: x = -123
// Output: -321

// Input: x = 120
// Output: 21