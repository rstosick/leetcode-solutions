/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public int minDepth(TreeNode root) {
    // Edge case: If the root is null, return 0
    if (root == null) return 0;

    // My original solution (prior to peaking at the answer)
    // was missing these two conditions, which caused the entire problem
    // to be inconsistently incorrect
    if (root.left == null) {
      return 1 + minDepth(root.right);
    }
    if (root.right == null) {
      return 1 + minDepth(root.left);
    }
    // My original solution had this line correct
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }
}
