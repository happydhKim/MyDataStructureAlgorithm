function solution(s, n) {
  return s.split('').map((key) => {
    if(' ' == key) {
      return key;
    }
    
    return key.toUpperCase().charCodeAt(0) + n > 90 
      ? String.fromCharCode(key.charCodeAt(0)+ n - 26) 
      : String.fromCharCode(key.charCodeAt(0) + n); 
    }).join('');
}