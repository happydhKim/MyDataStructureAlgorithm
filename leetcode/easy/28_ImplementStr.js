/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
  if ((haystack.length === 0 && needle.length === 0) || needle.length === 0) {
    return 0;
  }
  for (let i = 0; i < haystack.length; i++) {
    if (haystack[i] === needle[0] && needle.length + i <= haystack.length) {
      let flag = true;
      for (let j = 0; j < needle.length; j++) {
        if (haystack[i + j] !== needle[j]) {
          flag = false;
          break;
        }
      }
      if(flag) {
       return i;
      }
    }
  }

  return -1;
};
