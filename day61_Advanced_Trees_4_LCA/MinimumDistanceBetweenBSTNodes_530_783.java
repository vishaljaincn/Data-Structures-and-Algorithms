package day61_Advanced_Trees_4_LCA;

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

public class MinimumDistanceBetweenBSTNodes_530_783 {
    // Variable to store the minimum absolute difference between any two nodes
    int minDiff = Integer.MAX_VALUE;

    // Reference to the previous node during inorder traversal
    TreeNode prev;

    // Main function to get the minimum absolute difference in a BST
    public int getMinimumDifference(TreeNode root) {
        // Call the inorder traversal function
        inorder(root);
        // Return the final minimum absolute difference
        return minDiff;
    }

    // Helper function for inorder traversal
    public void inorder(TreeNode root) {
        // Base case: If the current TreeNode is null, return
        if (root == null) return;

        // Recursively traverse the left subtree
        inorder(root.left);

        // Check and update the minimum absolute difference
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }

        // Update the previous node reference
        prev = root;

        // Recursively traverse the right subtree
        inorder(root.right);
    }
}
