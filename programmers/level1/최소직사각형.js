function solution(sizes) {
  let answer = [0, 0];

  sizes.forEach(size => {
    size.sort((a, b) => a -  b);
    if (size[0] > answer[0]) answer[0] = size[0];
    if (size[1] > answer[1]) answer[1] = size[1];
  });

  return answer[0] * answer[1];
}


function solution(sizes) {
  const [hor, ver] = sizes.reduce(([h, v], [a, b]) => [Math.max(h, Math.max(a, b)), Math.max(v, Math.min(a, b))], [0, 0])

  return hor * ver;
}

// [[60, 50], [30, 70], [60, 30], [80, 40]]	4000
// [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
// [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133


console.log(solution([[60, 50], [30, 70], [60, 30], [80, 40]]));
console.log(solution([[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]));
console.log(solution([[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]));