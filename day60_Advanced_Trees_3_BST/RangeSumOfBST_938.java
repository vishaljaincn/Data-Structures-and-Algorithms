package day60_Advanced_Trees_3_BST;

/*
Given the root node of a binary search tree and two integers low and high, return the sum of values of all
nodes with a value in the inclusive range [low, high].
Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 */
// Time Complexity: O(N), Space Complexity: O(H) where N is the number of nodes, H is the height of the tree.

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
class RangeSumOfBST_938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // Base case: if the root is null, return 0
        if (root == null) {
            return 0;
        }

        // Check if the current node's value is within the range [low, high]
        if (root.val >= low && root.val <= high) {
            // If within range, include the current node's value in the sum
            // and recursively calculate the sum for left and right subtrees
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            // If the current node's value is less than low, recursively search only the right subtree
            return rangeSumBST(root.right, low, high);
        } else {
            // If the current node's value is greater than high, recursively search only the left subtree
            return rangeSumBST(root.left, low, high);
        }
    }
}
