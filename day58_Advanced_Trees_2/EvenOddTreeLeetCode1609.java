package day58_Advanced_Trees_2;
/*
A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
 */
import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTreeLeetCode1609 {
    public boolean isEvenOddTree(TreeNode root) {
        // Check if the tree is empty
        if (root == null) {
            return true; // An empty tree is considered an Even-Odd tree
        }

        // Initialize a queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0; // Start with the root level

        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();
            Integer prevValue = null;

            // Process each node at the current level
            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                TreeNode currentNode = queue.poll();

                // Check the parity of the value based on the level
                if ((level % 2 == 0 && (currentNode.val % 2 == 0 || (prevValue != null && prevValue >= currentNode.val)))
                        || (level % 2 == 1 && (currentNode.val % 2 == 1 || (prevValue != null && prevValue <= currentNode.val)))) {
                    return false; // Return false if the conditions are not met
                }

                prevValue = currentNode.val;

                // Enqueue the children of the current node if they exist
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            level++; // Move to the next level
        }

        return true; // The tree satisfies the Even-Odd conditions
    }
}
