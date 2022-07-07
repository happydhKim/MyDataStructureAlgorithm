function solution(nums) {
  const numbers = [...new Set(nums)].length;
  const limit = nums.length / 2;

  return numbers > limit ? limit : numbers;
}
