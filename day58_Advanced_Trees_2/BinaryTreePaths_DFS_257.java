package day58_Advanced_Trees_2;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.
Example 1:

Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 */
/*
Time Complexity: O(n) - where n is the number of nodes in the binary tree.
Space Complexity: O(h) - where h is the height of the binary tree (recursive call stack). In the worst case
(skewed tree), it can be O(n), but in a balanced tree, it's O(log n).
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
public class BinaryTreePaths_DFS_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node.left == null && node.right == null) {
            // Leaf node, add the path to the list
            paths.add(path + node.val);
        }

        // Traverse left subtree
        if (node.left != null) {
            dfs(node.left, path + node.val + "->", paths);
        }

        // Traverse right subtree
        if (node.right != null) {
            dfs(node.right, path + node.val + "->", paths);
        }
    }
}
