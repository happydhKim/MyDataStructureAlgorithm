/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  const result = [];
  const getCombination = (left, right, str) => {
    if (left === n && right === n) {
      result.push(str);
      return;
    }
    if (left < n) getCombination(left + 1, right, str + '(');
    if (left > right && right < n) getCombination(left, right + 1, str + ')');
  };
  getCombination(0, 0, '');

  return result;
};


console.log(generateParenthesis(3));
console.log(generateParenthesis(1));

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Input: n = 1
// Output: ["()"]