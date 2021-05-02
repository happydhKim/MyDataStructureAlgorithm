/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
 const dfs = (left, right) => {
  if(!left && !right) return true;
  if(!left || !right) return false;
  if(left.val !== right.val) return false;
  
  return dfs(left.left, right.right) && dfs(left.right, right.left)
};

var isSymmetric = function(root) {
  if(!root) return true;
  
  return dfs(root.left, root.right);
};

// Input: root = [1,2,2,3,4,4,3]
// Output: true

console.log(isSymmetric([1,2,2,3,4,4,3]));