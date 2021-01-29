function solution(strings, n) {
  return strings.sort((a, b) => {
    if(a.charAt(n) < b.charAt(n)) {
      return -1;
    }
    if(a.charAt(n) > b.charAt(n)) {
      return 1;
    }
    if(a < b) {
      return -1;
    }
    if(a > b) {
      return 1;
    }
    return 0;
  });
}