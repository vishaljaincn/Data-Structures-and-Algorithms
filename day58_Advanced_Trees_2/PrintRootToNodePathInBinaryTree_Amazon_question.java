package day58_Advanced_Trees_2;

import java.util.ArrayList;
import java.util.List;
/*
Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.
 */
// Time Complexity: O(n), where n is the number of nodes in the binary tree.
// Space Complexity: O(h), where h is the height of the binary tree (call stack during recursion).

public class PrintRootToNodePathInBinaryTree_Amazon_question {

    public static List<Integer> findPathToNode(TreeNode root, int x) {
        List<Integer> path = new ArrayList<>();
        if (findPath(root, x, path)) {
            return path;
        } else {
            return new ArrayList<>(); // Empty list if no path found
        }
    }

    private static boolean findPath(TreeNode node, int x, List<Integer> path) {
        if (node == null) {
            return false; // Base case: reached a null node, return false
        }

        path.add(node.val); // Add the current node to the path

        if (node.val == x) {
            return true; // Target node found, return true
        }

        // Recursively search in the left and right subtrees
        if (findPath(node.left, x, path) || findPath(node.right, x, path)) {
            return true; // Target node found in either subtree, return true
        }

        // If x is not present in the left or right subtree, backtrack
        path.remove(path.size() - 1);
        return false;
    }
}
