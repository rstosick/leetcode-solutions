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

    private boolean isUnivalueSubtree(TreeNode current, int rootValue) {
        if(current==null) return true;
        if(current.val!=rootValue) return false;
        boolean left = isUnivalueSubtree(current.left, rootValue);
        boolean right = isUnivalueSubtree(current.right, rootValue);
        return left&&right;
    }

    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;

        int count = 0;
        
        // check if current tree is a univalue subtree
        if(isUnivalueSubtree(root, root.val) == true) count++;

        if(root.left!=null) {
            count = count + countUnivalSubtrees(root.left);
        }
        if(root.right!=null) {
            count = count + countUnivalSubtrees(root.right);
        }
        return count;
    }
}