package day60_Advanced_Trees_3_BST;
//TC - O(H) = logN
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
class SearchBST_700 {

    public TreeNode searchBST_700(TreeNode root, int val) {
        // Use a temporary variable for traversal
        TreeNode temp = root;

        // Iterate until either the tree is empty, or the value is found
        while (temp != null) {
            // If the value is equal to the current node's value, return the node
            if (val == temp.val) {
                return temp;
            }

            // If the value is less than the current node's value, search in the left subtree
            if (val < temp.val) {
                temp = temp.left;
            } else {
                // If the value is greater than the current node's value, search in the right subtree
                temp = temp.right;
            }
        }

        // Return null if the value is not found
        return null;
    }
}
