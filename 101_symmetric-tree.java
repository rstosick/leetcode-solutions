/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {

  private boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    if (left.val != right.val) return false;
    boolean inner = isMirror(left.right, right.left);
    boolean outer = isMirror(left.left, right.right);
    return inner && outer;
  }

  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }
}
