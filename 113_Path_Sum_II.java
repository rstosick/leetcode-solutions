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

    void dfs(TreeNode current, int targetSum, List<Integer> path, List<List<Integer>> output) {
        if (current == null) {
            return;
        }
        
        // compute the remaining delta from target
        targetSum = targetSum - current.val; 
        
        path.add(current.val);
        if (current.left == null && current.right == null) {
            if (targetSum == 0) {
                List<Integer> validPath = new ArrayList<>(path);
                output.add(validPath);
            } else {
                // Do nothing here, but don't return yet
            }
        } else {
            dfs(current.left, targetSum, path, output);
            dfs(current.right, targetSum, path, output);
        }
        path.remove(path.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), output);
        return output;
    }
}