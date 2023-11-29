package day61_Advanced_Trees_4_LCA;

import java.util.ArrayList;
import java.util.List;

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
//TC - O(N)
//SC - O(1)
// Morris Traversal for Preorder
class MorrisTraversalForPreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();

        // Start with the root of the tree
        TreeNode cur = root;
        while (cur != null) {
            // If there is no left child, visit the node and move to the right child
            if (cur.left == null) {
                preorder.add(cur.val);
                cur = cur.right;
            } else {
                // If there is a left child, find the rightmost node in the left subtree
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the rightmost node's right pointer is null, establish a link and move to the left child
                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.val);
                    cur = cur.left;
                } else {
                    // If the rightmost node's right pointer is not null, break the link and move to the right child
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }

        // Return the list containing values in preorder traversal
        return preorder;
    }
}
