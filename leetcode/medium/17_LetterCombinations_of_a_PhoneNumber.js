/**
 * @param {string} digits
 * @return {string[]}
 */
const DIGITS = {
  2: ['a', 'b', 'c'],
  3: ['d', 'e', 'f'],
  4: ['g', 'h', 'i'],
  5: ['j', 'k', 'l'],
  6: ['m', 'n', 'o'],
  7: ['p', 'q', 'r', 's'],
  8: ['t', 'u', 'v'],
  9: ['w', 'x', 'y', 'z'],
}

var letterCombinations = function(digits) {
  const digit = digits.split('');
  const answer = [];

  const getNextCombinations = (depth, str) => {
    if (depth === digit.length) {
      if(str === '') return;
      answer.push(str);
      
      return;
    }
    for (let i = 0; i < DIGITS[digit[depth]].length; i++) {
      getNextCombinations(depth + 1, str + DIGITS[digit[depth]][i]);
    }
  };

  getNextCombinations(0, '');

  return answer;
};

console.log(letterCombinations(''));

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]