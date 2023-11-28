package day60_Advanced_Trees_3_BST;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BSTIterator_173 {
    // Stack to store nodes in the order of traversal
    private Stack<TreeNode> stack = new Stack<>();

    // Constructor to initialize the iterator with the given root
    public BSTIterator_173(TreeNode root) {
        // Initialize the stack with the leftmost path of the tree
        pushAll(root);
    }

    // Method to retrieve the next smallest element in the BST
    public int next() {
        // Pop the current node from the stack
        TreeNode node = stack.pop();
        // Add all nodes from the right subtree of the current node
        pushAll(node.right);
        // Return the value of the current node
        return node.val;
    }

    // Method to check if there are more elements in the BST
    public boolean hasNext() {
        // Return true if the stack is not empty, indicating there are more elements
        return !stack.isEmpty();
    }

    // Helper method to push all nodes along the leftmost path of the tree onto the stack
    private void pushAll(TreeNode root) {
        while (root != null) {
            // Push the current node onto the stack
            stack.push(root);
            // Move to the left child of the current node
            root = root.left;
        }
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
