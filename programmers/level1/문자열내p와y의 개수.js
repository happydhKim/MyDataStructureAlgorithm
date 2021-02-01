function solution(s){
  const str = s.toUpperCase();

  let pCount = 0;
  let yCount = 0;
  for (let i = 0; i < str.length; i++) {

    if(str[i] === 'P') pCount++;
    if(str[i] === 'Y') yCount++;
  }
  return pCount === yCount ? true : false;
}

console.log(solution('pPoooyY'));