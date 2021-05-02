/**
 * @param {number[]} stones
 * @return {number}
 */
const smashStones = (x, y) => {
  if (x === y) {
    return false;
  } else if(x !== y) {
    return Math.abs(x - y);
  }
};

var lastStoneWeight = function(stones) {
  while (stones.length > 1) {
    stones.sort((a, b) => b - a);
    const result = smashStones(stones[0], stones[1]);
    result
      ? stones.splice(0, 2, result)
      : stones.splice(0, 2);
  }

  return stones.length 
    ? stones[0]
    : 0;
};


lastStoneWeight([1,3]);
