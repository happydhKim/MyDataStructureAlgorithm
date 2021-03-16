const solution = (
  n,
  arr1,
  arr2,
) => arr1.map((value, index) =>
  (value | arr2[index])
    .toString(2)
    .padStart(n, 0)
    .replace(/0/g, ' ')
    .replace(/1/g, '#')
);

console.log(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]));
console.log(solution(6, [46, 33, 33 ,22, 31, 50], [27 ,56, 19, 14, 14, 10]));
