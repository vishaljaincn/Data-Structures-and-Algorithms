package day58_Advanced_Trees_2;

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
 */
// Time complexity: O(N), Space complexity: O(h) where N is the number of nodes and h is the height of the tree.

public class SymmetricTree_101 {
    // The main function to check if the tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // If the tree is empty, it is symmetric
        if (root == null) {
            return true;
        }
        // Call the helper function to check if the left and right subtrees are mirrors
        return isMirror(root.left, root.right);
    }

    // Helper function to check if two subtrees are mirrors of each other
    private boolean isMirror(TreeNode left, TreeNode right) {
        // If both nodes are null, they are mirrors
        if (left == null && right == null) {
            return true;
        }
        // If only one of the nodes is null, they are not mirrors
        if (left == null || right == null) {
            return false;
        }
        // Check if the values are equal and the left subtree's left is a mirror of the right subtree's right
        // and the left subtree's right is a mirror of the right subtree's left
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        // You can create a sample tree and test the function
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        // root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(3);

        // Solution solution = new Solution();
        // boolean result = solution.isSymmetric(root);
        // System.out.println(result);
    }
}
