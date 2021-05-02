/**
 * @param {number} k
 * @param {number[]} nums
 */
var KthLargest = function(k, nums) {
  this.nums = nums;
  this.k = k;
};

/** 
 * @param {number} val
 * @return {number}
 */
KthLargest.prototype.add = function(val) {
  this.nums.push(val);
  this.nums.sort((a, b) => a - b);

  return this.nums[Math.abs(this.k - this.nums.length)];
};

/** 
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */

// [10, 9, 8, 5, 5, 4, 3, 2]
// [2, 3, 4, 5, 8, 10]
const kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
console.log(KthLargest([[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]));


const binarySearch = (nums, target) => {
  let startIndex = 0;
  let endIndex = nums.length - 1;

  while (startIndex <= endIndex) {
    const middleIndex = Math.floor((startIndex + endIndex) / 2);
    const nextTarget = nums[middleIndex];

    if (nextTarget === target) {
      return middleIndex;
    }

    nextTarget < target
      ? startIndex = middleIndex + 1
      : endIndex = middleIndex - 1;
  }
};