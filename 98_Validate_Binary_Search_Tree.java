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

    private boolean isValidBstHelper(TreeNode currentNode, Integer lowerLimit, Integer upperLimit) {
        if (currentNode == null)
            return true;
        if (lowerLimit != null) {
            if (currentNode.val <= lowerLimit)
                return false;
        }
        if (upperLimit != null) {
            if (currentNode.val >= upperLimit)
                return false;
        }
        if(!isValidBstHelper(currentNode.left, lowerLimit, (int) currentNode.val)) return false;
        if(!isValidBstHelper(currentNode.right, (int) currentNode.val, upperLimit)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBstHelper(root, null, null);
    }
}