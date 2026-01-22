/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {

  private int currentBest = Integer.MAX_VALUE;
  private double target = Integer.MIN_VALUE;
  private double bestDelta = Double.MAX_VALUE;

  private double currentDelta; // can lift this out of the helper function to reduce memory usage

  public void helper(TreeNode current) {
    // if helper is called on a null node, don't update anything
    if (current == null) return;

    currentDelta = Math.abs(target - (double) current.val);
    // Check if the current node is better than the best we've found thus far
    if (currentDelta < this.bestDelta) {
      this.currentBest = current.val;
      this.bestDelta = currentDelta;
    } else if (currentDelta == this.bestDelta) {
      if (current.val < this.currentBest) {
        this.currentBest = current.val;
        this.bestDelta = currentDelta;
      }
    }
    helper(current.left);
    helper(current.right);
  }

  public int closestValue(TreeNode root, double target) {
    if (root == null) return 0;
    this.currentBest = root.val;
    this.target = target;
    this.bestDelta = Math.abs(this.target - (int) this.currentBest);
    helper(root);
    return this.currentBest;
  }
}
