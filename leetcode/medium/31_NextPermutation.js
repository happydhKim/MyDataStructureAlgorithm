/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
  for(let i = nums.length - 1; i >= 0; i--) {
    if(nums[i] < nums[i + 1]) {
      const large = nextLarge(i);
      swap(i, large);
      reverse(i + 1);
      return nums;
    }
  }

  nums.reverse();

  function swap(i, j) {
    [nums[i], nums[j]] = [nums[j], nums[i]];
  }

  function reverse(index) {
    let start = index;
    let end = nums.length - 1;
    
    while(start < end) {
      swap(start, end);
      start++;
      end--;
    }
  }

  function nextLarge(index) {
    for(let i = nums.length - 1; i > index; i--) {
      if(nums[i] > nums[index]) return i;
    }
  }

  return nums;
};

// console.log(nextPermutation([1,2,3]));
console.log(nextPermutation([1,2,3,8,5,6]));
// console.log(nextPermutation([3,2,1]));
// console.log(nextPermutation([1,1,5]));

// Input: nums = [1,2,3]
// Output: [1,3,2]

// Input: nums = [3,2,1]
// Output: [1,2,3]

// Input: nums = [1,1,5]
// Output: [1,5,1]