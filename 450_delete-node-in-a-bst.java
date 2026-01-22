/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {

  private TreeNode findMinHelper(TreeNode node) {
    while (node.left != null) node = node.left;
    return node;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (root.val != key) {
      if (key < root.val) {
        root.left = deleteNode(root.left, key);
      } else {
        root.right = deleteNode(root.right, key);
      }

    } else {
      // we have found the value to be deleted

      if (root.left == null && root.right == null) {
        // it is a leaf node, just delete it
        return null;
      } else if (root.left == null || root.right == null) {
        if (root.left == null) {
          // make root.right the new root
          return root.right;
        } else {
          return root.left;
        }
      } else {
        // Neither the left nor the right are null
        TreeNode successor = findMinHelper(root.right);
        root.val = successor.val;
        root.right = deleteNode(root.right, successor.val);
      }
    }
    return root;
  }
}
