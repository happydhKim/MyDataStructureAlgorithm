function combination(arr, num){
  const response = [];
  if(num === 1) return arr.map((v) => [v]);

  arr.forEach((v, idx, arr) => {
    const rest = arr.slice(idx+1);
    const combinations = combination(rest, num-1);
    const attach = combinations.map((combination) => [v, ...combination]);

    response.push(...attach);
  })

  return response;
}

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
  const combinationArray = combination(nums, 3);

  const sortedComb = combinationArray.filter(comb => comb[0] + comb[1] + comb[2] === 0).map(comb => comb.sort());
  
  let answer = [];
  let itemsFound = {};
  sortedComb.forEach(comb => {
    const stringified = JSON.stringify(comb);
    if (!itemsFound[stringified]) {
      answer.push(comb);
      itemsFound[stringified] = true;
    }
  });

  return answer;
};


console.log(threeSum([-1,0,1,2,-1,-4]));
console.log(threeSum([0,1,1]));
console.log(threeSum([0,0,0]));

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// Input: nums = [0,1,1]
// Output: []

// Input: nums = [0,0,0]
// Output: [[0,0,0]]


// combination 으로 푸니 runtime error 나와서 다시 해봐야 함