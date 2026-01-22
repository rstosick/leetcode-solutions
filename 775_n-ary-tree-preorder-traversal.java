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
};
*/

class Solution {

  public void preorderRecursiveTraversalHelper(Node root, List<Integer> output) {
    if (root == null) return;
    output.add(root.val);
    for (Node x : root.children) {
      if (x != null) {
        preorderRecursiveTraversalHelper(x, output);
      }
    }
  }

  public List<Integer> preorder(Node root) {
    List<Integer> output = new ArrayList<>();
    preorderRecursiveTraversalHelper(root, output);
    return output;
  }
}
