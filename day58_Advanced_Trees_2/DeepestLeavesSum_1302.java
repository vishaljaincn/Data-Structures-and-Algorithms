package day58_Advanced_Trees_2;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, return the sum of values of its deepest leaves.

Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

Example 2:
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19

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
/*
Time complexity: O(N) where N is the number of nodes in the binary tree.
Space complexity: O(N) there are total of (N+1)/2 leaves in the complete binary tree
*/
class DeepestLeavesSum_1302 {
    int sum = 0; // Variable to store the sum of the deepest leaves

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>(); // Queue for level-order traversal
        q.offer(root);

        while (!q.isEmpty()) {
            int currentSize = q.size();
            sum = 0; // Reset sum for the current level

            // Traverse all nodes at the current level
            for (int i = 0; i < currentSize; i++) {
                TreeNode temp = q.poll();
                sum += temp.val; // Add the value of the current node to the sum

                // Enqueue the left and right children if they exist
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }

        return sum; // Return the sum of the deepest leaves
    }
}
