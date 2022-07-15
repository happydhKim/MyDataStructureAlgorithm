const isPalindrome = (s) => {
  for (let i = 0; i < s.length; i++) {
    if (s[i] !== s[s.length - 1 - i]) {
      return false;
    }
  }
  return true;
}

/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
  if (s.length === 1) return s;
  let answer = '';
  for (let i = 0; i < s.length; i++) {
    for (let j = s.length; j > i; j--) {
      if (answer.length > j - i) {
        break;
      }
      const sliceStr = s.slice(i, j);
      if (isPalindrome(sliceStr) && answer.length < sliceStr.length) {
        answer = sliceStr;
        break;
      }
    }    
  }
  return answer;
};

console.log(longestPalindrome('babad'));
console.log(longestPalindrome('babab'));
console.log(longestPalindrome('aa'));
console.log(longestPalindrome('cbbd'));

// console.log(isPalindrome('babad'));
// console.log(isPalindrome('babab'));
// console.log(isPalindrome('bb'));
// console.log(isPalindrome('aba'));
// console.log(isPalindrome('abbaa'));
// console.log(isPalindrome('a'));
// babad
// babab
// cbbd
