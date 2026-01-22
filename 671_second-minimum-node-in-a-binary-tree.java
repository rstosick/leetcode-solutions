/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  private int findSmallestValue(TreeNode root) {
    if (root == null) return -1;
    int smallest = root.val;
    int left = findSmallestValue(root.left);
    int right = findSmallestValue(root.right);
    if (left == -1) {
      if (right != -1) smallest = right;
    }
    if (right == -1) {
      if (left != -1) smallest = left;
    } else smallest = Math.min(left, right);
    return smallest;
  }

  private int findSmallestValueAboveThreshold(TreeNode root, int input) {
    int output = -1;
    if (root == null) {
      // System.out.printf("findSmallestValueAboveThreshold called on null value\n");
      return -1;
    } else {
      // System.out.printf("findSmallestValueAboveThreshold called on node.val=%d\n", root.val);
    }
    if (root.val >= input) output = root.val;

    int left = findSmallestValueAboveThreshold(root.left, input);
    int right = findSmallestValueAboveThreshold(root.right, input);
    if (left == -1) {
      if (right != -1) {
        // smallest = right
        if (right > output) output = right;
      }
      ;
    } else if (right == -1) {
      if (left != -1) {
        // smallest = left;
        if (left > output) output = left;
      }
    } else {
      // Neither left nor right are -1
      output = Math.min(left, right);
    }
    // System.out.printf("findSmallestValueAboveThreshold called on node.val=%d, output=%d\n",
    // root.val, output);
    return output;
  }

  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) return -1;
    // int output = -1;
    int smallestValue = findSmallestValue(root);
    if (smallestValue == Integer.MAX_VALUE) return -1;
    System.out.printf("smallest value = %d\n", smallestValue);
    int secondSmallestValue = findSmallestValueAboveThreshold(root, smallestValue + 1);
    System.out.printf("secondSmallestValue = %d\n", secondSmallestValue);
    return secondSmallestValue;
  }
}
