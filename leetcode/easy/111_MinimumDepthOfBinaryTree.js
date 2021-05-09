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
 * @return {number}
 */
var minDepth = function(root) {
  let depth = 1;
  let queue = [root];

  while (queue.length > 0) {
    let len = queue.length;
    
    for (let i = 0; i < len; i++) {
      let node = queue.shift();
      if (node === null) return 0;
      if (node.left === null && node.right === null) return depth;
      if (node.left !== null) queue.push(node.left);
      if (node.right !== null) queue.push(node.right);
    }
    depth++;
  }
  return depth;
};



console.log(minDepth([2,null,3,null,4,null,5,null,6]));
