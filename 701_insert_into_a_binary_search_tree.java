/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public TreeNode insertIntoBST(TreeNode root, int insertVal) {
    if (root == null) {
      // create new node
      return new TreeNode(insertVal);
    }
    if (insertVal < root.val) {
      root.left = insertIntoBST(root.left, insertVal);
    } else {
      root.right = insertIntoBST(root.right, insertVal);
    }
    return root;
  }
}
