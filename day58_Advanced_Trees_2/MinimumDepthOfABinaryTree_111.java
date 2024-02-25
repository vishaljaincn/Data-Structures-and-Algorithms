package day58_Advanced_Trees_2;

import java.util.LinkedList;
import java.util.Queue;
/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the
nearest leaf node.

Note: A leaf is a node with no children.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 */

// Time complexity: O(n), where n is the number of nodes in the binary tree.
// Space complexity: O(m), where m is the maximum number of nodes at any level in the binary tree (worst-case scenario is the bottom level).

public class MinimumDepthOfABinaryTree_111 {
    // Method to find the minimum depth of a binary tree
    public int minDepth(TreeNode root) {
        // If the tree is empty, the depth is 0
        if (root == null) {
            return 0;
        }

        // Use a queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start with the root node
        int depth = 1;  // Initialize depth to 1

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // If the current node is a leaf node, return the current depth
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                // Add child nodes to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Move to the next level
            depth++;
        }

        // This point is reached if the tree is skewed and has only left or right children
        // Return the depth of the last level encountered
        return depth;
    }
}
