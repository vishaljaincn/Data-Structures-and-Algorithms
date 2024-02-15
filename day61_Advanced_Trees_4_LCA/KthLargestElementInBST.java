package day61_Advanced_Trees_4_LCA;

import java.util.Stack;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left = null;
 * right = null;
 * }
 * }
 */
public class KthLargestElementInBST {

    public int kthLargest(TreeNode root, int k) {
        int n = countNodes(root);  // Calculate total number of nodes
        int target = n - k;  // Calculate the target (n - k)th smallest element
        return findKthSmallest(root, target);
    }

    private int findKthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                // Traverse the left subtree and push nodes onto the stack
                stack.push(current);
                current = current.left;
            } else {
                // Pop a node from the stack, decrement k, and check if it's the target (n - k)th smallest element
                current = stack.pop();
                k--;

                if (k == 0) {
                    return current.val;  // Found the kth largest element
                }

                // Move to the right subtree
                current = current.right;
            }
        }

        return -1;  // Return -1 if kth element is not found
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
