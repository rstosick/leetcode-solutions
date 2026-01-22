/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int diameter=0;

    private int maxTreeDepth(TreeNode root) {
        if(root==null) return 0;
        int left = maxTreeDepth(root.left);
        int right = maxTreeDepth(root.right);
        diameter = Math.max(diameter, left+right);
        return 1+Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        maxTreeDepth(root);
        return diameter;
    }
}