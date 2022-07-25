/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
 var fourSum = function(nums, target) {
	nums.sort((a, b) => a - b);
	const answer = [];

	if(nums.length < 3) return answer

	for(let i = 0; i < nums.length - 3; i++){
    for (let j = i + 1; j < nums.length - 2; j++) {
      let left = j + 1;
      let right = nums.length - 1;  
      while (left < right) {
        let sum = nums[i] + nums[j] + nums[left] + nums[right];
        if (sum === target) {
          let arr = [nums[i], nums[j], nums[left], nums[right]];
          answer.push(arr);
          while (nums[left + 1] === nums[left]) left++;
          while (nums[right - 1] === nums[right]) right--;
          left++;
          right--;
        } else if (sum > target) {
          right--;
        } else {
          left++;
        }
      }
      while (nums[j + 1] === nums[j]) j++;
    }
    while (nums[i + 1] === nums[i]) i++;
	}

	return answer
};


console.log(fourSum([1,0,-1,0,-2,2], 0));
console.log(fourSum([2,2,2,2], 8));
// console.log(fourSum([-493,-482,-482,-456,-427,-405,-392,-385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,-177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,-18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492], 6189))

// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]