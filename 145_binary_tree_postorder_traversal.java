/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

// Post-order Traversal
// Post-order traversal is to traverse the left subtree first.
// Then traverse the right subtree. Finally, visit the root.

class Solution {

  private List<Integer> result = null;

  private void helper(TreeNode current) {
    if (current == null) return;
    helper(current.left);
    helper(current.right);
    result.add(current.val);
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    result = new ArrayList<>();
    helper(root);
    return result;
  }
}
