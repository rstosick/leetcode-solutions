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

// In-order Traversal:
// In-order traversal is to traverse the left subtree first.
// Then visit the root. Finally, traverse the right subtree.
// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/

class Solution {

    private List<Integer> result = null;

    private void helper(TreeNode current) {
        if(current==null) return;
        helper(current.left);
        result.add(current.val);
        helper(current.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        helper(root);
        return result;
    }
}