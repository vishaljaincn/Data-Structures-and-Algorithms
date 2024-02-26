package day58_Advanced_Trees_2;
/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

//Time Complexity: O(m * n), where m and n are the number of nodes in trees s and t, respectively.
//Space Complexity: O(max(m, n)), the maximum depth of the recursion stack.

public class SubTreeOfAnotherTree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // Base case: if the main tree is null, t cannot be a subtree
        if (s == null) {
            return false;
        }

        // Check if the current subtree rooted at s is equal to t
        if (isSameTree(s, t)) {
            return true;
        }

        // Recursively check the left and right subtrees
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // Helper function to check if two trees are identical
    private boolean isSameTree(TreeNode s, TreeNode t) {
        // Base case: both trees are null, they are equal
        if (s == null && t == null) {
            return true;
        }

        // If one of the trees is null and the other is not, they are not equal
        if (s == null || t == null) {
            return false;
        }

        // Check if the current nodes have the same value
        if (s.val != t.val) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
