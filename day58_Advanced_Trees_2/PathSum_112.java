package day58_Advanced_Trees_2;

/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf
path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.
Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
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
// Time complexity: O(N), Space complexity: O(H), where N is the number of nodes, and H is the height of the tree.
public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Base case: If the root is null, return false.
        if (root == null) {
            return false;
        }

        // If the current node is a leaf and its value equals the remaining sum, return true.
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }

        // Recursively check the left and right subtrees with the updated sum.
        boolean leftPath = hasPathSum(root.left, sum - root.val);
        boolean rightPath = hasPathSum(root.right, sum - root.val);

        // Return true if there's a path in either the left or right subtree.
        return leftPath || rightPath;
    }
}
