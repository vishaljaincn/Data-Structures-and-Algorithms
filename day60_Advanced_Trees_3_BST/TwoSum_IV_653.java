package day60_Advanced_Trees_3_BST;

/*
Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST
such that their sum is equal to k, or false otherwise.
Example 1:
Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

Example 2:
Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity: O(N), where N is the number of nodes. Space Complexity: O(N), due to the
// HashSet storing node values.

class TwoSum_IV_653 {

    boolean findTarget(TreeNode root, int k) {
        // Set to store visited node values
        Set<Integer> set = new HashSet<>();

        // Call recursive helper function to check for target sum
        return findTargetHelper(root, k, set);
    }

    private boolean findTargetHelper(TreeNode node, int k, Set<Integer> set) {
        // Base case: if the current node is null, return false
        if (node == null) {
            return false;
        }

        // Check if the complement (k - node.val) exists in the set
        if (set.contains(k - node.val)) {
            return true; // Found a pair with sum equal to k
        }

        // Add the current node's value to the set
        set.add(node.val);

        // Check in both left and right subtrees
        return findTargetHelper(node.left, k, set) || findTargetHelper(node.right, k, set);
    }
}
