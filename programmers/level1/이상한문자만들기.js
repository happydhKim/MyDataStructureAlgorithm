function solution(s) {
  return s.split(' ').map(key => {
      let result = '';
      for(let i = 0; i < key.length; i++) {
          if(i % 2) {
              result += key[i].toLowerCase();
          } else {
              result += key[i].toUpperCase();
          }
      }
      return result;
  }).join(' ');
}
