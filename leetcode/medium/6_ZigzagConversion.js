/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
 var convert = function(s, numRows) {
  let result = [];
  let step = 1;
  let index = 0;

  for (let i = 0; i < s.length; i++) {
    if (!result[index]) {
      result[index] = '';
    }
    result[index] += s[i];
    if (index === 0) {
      step = 1;
    } else if (index === numRows - 1) {
      step = -1;
    }
    index += step;
    
  }
  return result.join('');
};




console.log(convert('PAYPALISHIRING', 3));
console.log(convert('PAYPALISHIRING', 4));
// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
// P   A   H   N
// A P L S I I G
// Y   I   R

// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
