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

    private void levelOrderHelper(int level, TreeNode current, Map<Integer, List<Integer>> map) {
        if (current == null)
            return;
        if (level < 0)
            throw new IllegalArgumentException("invalid level");
        List<Integer> levelList = map.computeIfAbsent(level, k -> new ArrayList<>());
        levelList.add(current.val);
        levelOrderHelper(level + 1, current.left, map);
        levelOrderHelper(level + 1, current.right, map);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // We could use a List of List<Integer> but 
        // I think a map is easier to debug
        Map<Integer, List<Integer>> map = new HashMap<>();
        levelOrderHelper(0, root, map);
        return new ArrayList<>(map.values());
    }
}