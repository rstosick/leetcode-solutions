/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

// Pre-order Traversal:
// Pre-order traversal is to visit the root first. Then traverse the left subtree.
// Finally, traverse the right subtree. Here is an example:
// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/

class Solution {

  private List<Integer> result = null;

  private void helper(TreeNode current) {
    if (current == null) return;
    result.add(current.val);
    helper(current.left);
    helper(current.right);
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    result = new ArrayList<Integer>();
    // if(root==null) return result;
    helper(root);
    return result;
  }
}
