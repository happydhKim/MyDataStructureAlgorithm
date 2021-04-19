/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function(n) {
  let current = '1';
    
  for (let i = 1; i < n; ++i) {
    let temp = '';
    
    let cursor = 0;
    let lastChar = current[0];
    let count = 0;
    
    while (cursor < current.length) {
      if (lastChar !== current[cursor]) {
        temp += count + lastChar;
        lastChar = current[cursor];
        count = 0;
      }
      cursor += 1;
      count += 1;
    }
    
    temp += count + lastChar;
    current = temp;
  }
  
  return current;
};