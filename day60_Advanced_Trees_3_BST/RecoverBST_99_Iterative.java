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
//TC - O(N)
//SC - O(H)  
class RecoverBST_99_Iterative {
    TreeNode first, last, prev, middle;

    public void recoverTree(TreeNode root) {
        // Initialize pointers
        first = null;   // First misplaced node
        last = null;    // Second misplaced node
        prev = new TreeNode(Integer.MIN_VALUE);
        middle = null;  // Middle node in case of consecutive violations

        // Traverse the tree to find the two misplaced nodes and the middle node
        inorderTraversal(root);

        // If there are two non-consecutive violations, swap the values of the first and last nodes
        if (first != null && last != null) {
            // Swap values of the first and last nodes to correct the first violation
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // If there are two consecutive violations, swap the values of the first and middle nodes
        else if (first != null && middle != null) {
            // Swap values of the first and middle nodes to correct the first violation
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();  // Use a stack for iterative traversal

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                // Traverse the left subtree and push nodes onto the stack
                stack.push(root);
                root = root.left;
            } else {
                // Pop a node from the stack, check for misplaced nodes, and move to the right subtree
                root = stack.pop();

                // Check for misplaced nodes
                if (first == null && root.val < prev.val) {
                    // First violation: update the first misplaced node and the middle node
                    first = prev;
                    middle = root;
                }
                if (first != null && root.val < prev.val) {
                    // Second violation: update the second misplaced node
                    last = root;
                }

                // Update the previous node
                prev = root;
                root = root.right;
            }
        }
    }
}
