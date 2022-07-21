/**
 * @param {number} num
 * @return {string}
 */
 var intToRoman = function(num) {
  let answer = '';
  if (num < 1 || num > 3999) return answer;
  
  let number = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
  let token = ['M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I'];
  
  let i = 0;
  while (num > 0){
    if (num - number[i] >= 0) {
      answer += token[i];
      num -= number[i];
    } else {
      i++;
    }
  }
  return answer;
};


console.log(intToRoman(3));
console.log(intToRoman(58));
console.log(intToRoman(1994));

// Input: num = 3
// Output: "III"
// Explanation: 3 is represented as 3 ones.

// Input: num = 58
// Output: "LVIII"
// Explanation: L = 50, V = 5, III = 3.

// Input: num = 1994
// Output: "MCMXCIV"
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.