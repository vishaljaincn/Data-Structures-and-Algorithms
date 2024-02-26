package day58_Advanced_Trees_2;

/*
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

Example 2:
Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

Example 3:
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 */

import java.util.LinkedList;
import java.util.Queue;

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

// Time complexity: O(N) where N is the number of nodes in the binary tree
// Space complexity: O(W) where W is the maximum width of the binary tree in any level

// Represents a pair containing a TreeNode and its corresponding index
class Pair {
    TreeNode node;  // TreeNode object
    int index;      // Index representing the position of the TreeNode

    // Constructor to initialize the Pair with a TreeNode and its index
    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

// Class containing the solution method
class MaximumWidthOfBinaryTree_662 {
    // Method to calculate the maximum width of a binary tree
    public int widthOfBinaryTree(TreeNode root) {
        // Check if the root is null, return 0 for an empty tree
        if (root == null) {
            return 0;
        }

        // Initialize a queue to perform level order traversal
        Queue<Pair> queue = new LinkedList<>();
        // Add the root node to the queue with an initial index of 0
        queue.add(new Pair(root, 0));

        // Variable to track the maximum width of the binary tree
        int maxWidth = 0;

        // Loop through each level of the binary tree
        while (!queue.isEmpty()) {
            // Get the size of the current level
            int levelSize = queue.size();
            // Initialize variables to track the start and end indices of the current level
            int levelStart = 0;
            int levelEnd = 0;

            // Process each node in the current level
            for (int i = 0; i < levelSize; i++) {
                // Dequeue a Pair object representing a TreeNode and its index
                Pair pair = queue.poll();
                TreeNode node = pair.node;

                // If it's the first node in the level, update the levelStart index
                if (i == 0) {
                    levelStart = pair.index;
                }

                // If it's the last node in the level, update the levelEnd index
                if (i == levelSize - 1) {
                    levelEnd = pair.index;
                }

                // Enqueue the left child with a doubled index
                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * pair.index));
                }

                // Enqueue the right child with a doubled index plus one
                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * pair.index + 1));
                }
            }

            // Update the maxWidth with the width of the current level
            maxWidth = Math.max(maxWidth, levelEnd - levelStart + 1);
        }

        // Return the maximum width of the binary tree
        return maxWidth;
    }
}
