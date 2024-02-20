package day58_Advanced_Trees_2;

/*
Given the root of a binary tree, invert the tree, and return its root.
Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []
 */

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
// Time: O(n), where n is the number of nodes in the tree
// Space: O(h), where h is the height of the tree (recursive stack space)


//THE GIVEN CODE PERFORMS A **POST-ORDER** TRAVERSAL OF THE BINARY TREE. IN A **POST-ORDER**
// TRAVERSAL, THE ALGORITHM VISITS THE LEFT SUBTREE, THEN THE RIGHT SUBTREE, AND FINALLY THE ROOT.
class InvertABinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the tree is empty...
        if (root == null) {
            return root;
        }

        // Call the function recursively for the left subtree...
        invertTree(root.left);
        // Call the function recursively for the right subtree...
        invertTree(root.right);

        // Swapping process: swap the left and right subtrees of the current node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root; // Return the root after inversion...
    }
}
