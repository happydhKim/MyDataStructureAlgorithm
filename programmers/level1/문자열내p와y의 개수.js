function solution(s){
  const str = s.toUpperCase();

  return str.split('P').length === str.split('Y').length;
}
