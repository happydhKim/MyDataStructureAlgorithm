/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
  // 아래 두 개 조건문은 없어도 통과함
  if (x < 0) return false;
  if (x < 10) return true;

  return Number([...(x + '')].reverse().join('')) === x;
};

console.log(isPalindrome(-123454231));
console.log(isPalindrome(123454231));
console.log(isPalindrome(123454321));