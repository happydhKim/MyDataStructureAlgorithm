function solution(clothes) {
  let answer = 1;
  let object = {};
  
  for (let i = 0; i < clothes.length; i++) {
    object[clothes[i][1]] = (object[clothes[i][1]] || 1) + 1;
  }

  for (let key in object) {
    answer *= object[key];
  }
  
  return answer - 1;
}