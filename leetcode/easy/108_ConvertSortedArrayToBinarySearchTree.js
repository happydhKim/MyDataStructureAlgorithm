/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

 function TreeNode(val, left, right) {
  this.val = (val===undefined ? 0 : val)
  this.left = (left===undefined ? null : left)
  this.right = (right===undefined ? null : right)
}

/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function(nums) {
  if (nums == null || !nums.length) {
    return null;
  }

  let middleIndex = Math.floor(nums.length / 2);

  const node = new TreeNode(nums[middleIndex]);
  node.left = sortedArrayToBST(nums.slice(0, middleIndex));
  node.right = sortedArrayToBST(nums.slice(middleIndex + 1, nums.length));
  console.log(node);

  return node;   
};

console.log(sortedArrayToBST([-10,-3,0,5,9]));