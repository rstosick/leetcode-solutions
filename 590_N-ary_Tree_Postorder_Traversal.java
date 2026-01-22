/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    private void postorderTraversalRecursive(Node root, List<Integer> output) {
        if(root==null) return;
        for(Node x: root.children) {
            postorderTraversalRecursive(x, output);
        }
        output.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> output = new ArrayList<>();
        postorderTraversalRecursive(root, output);
        return output;
    }
}