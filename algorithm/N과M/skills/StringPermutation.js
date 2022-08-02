const permutationString = str => {
  if (str.length <= 2) return str.length === 2 ? [str[0] + str[1], str[1] + str[0]] : [str];
  return str
     .split('')
     .reduce(
        (accumulator, letter, i) =>
         accumulator.concat(permutationString(str.slice(0, i) + str.slice(i + 1)).map(val => letter + val)),[]);
};

console.log(permutationString('abcd'));