import static java.lang.Integer.max;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {

  private int getHeight(TreeNode node) {
    if (node == null) return 0;
    return max(getHeight(node.left), getHeight(node.right)) + 1;
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    int delta = Math.abs(getHeight(root.left) - getHeight(root.right));
    if (delta > 1) return false;
    else return isBalanced(root.left) && isBalanced(root.right);
  }
}
