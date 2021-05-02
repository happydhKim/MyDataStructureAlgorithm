/**
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 */
var getHint = function(secret, guess) {
  const length = secret.length;
  const hash = {};

  let bulls = 0;
  let cows = 0;

  for (let i = 0; i < length; i++) {
      const digit = secret[i];
      hash[digit]
        ? hash[digit] += 1
        : hash[digit] = 1;
  };
  for (let i = 0; i < length; i++) {
      const digit = guess[i];
      if (hash[digit]) {
        cows += 1;
        hash[digit] -= 1;
      };
      if (secret[i] === guess[i]) {
        bulls += 1;
      };
  };

  return `${bulls}A${(cows - bulls)}B`;
};

getHint('1807', '7810');