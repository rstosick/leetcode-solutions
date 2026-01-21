/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    // We can take advantage of the next pointer being
    // null by default to simplify the logic
    // We can also take advantage of the binary tree being 
    // "perfect" to simplify the logic
    private void helper(Node node) {
        if(node==null) return;
        
        // If the current node's left child is not null
        if(node.left!=null) {
            // Set the left child's next to the right node
            node.left.next = node.right;
            
            // If the current node's next isn't null,
            // then set the right child's next to
            // the left child of the parent's next
            if(node.next!=null) {
                node.right.next = node.next.left;
            }
        }
        helper(node.left);
        helper(node.right);
    }

    public Node connect(Node root) {
        helper(root);
        return root;
    }
}