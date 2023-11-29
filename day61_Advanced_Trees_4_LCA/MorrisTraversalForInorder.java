package day61_Advanced_Trees_4_LCA;

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int key) {
        val = key;
        left = right = null;
    }
}
//TC - O(N)
//SC - O(1)
class MorrisTraversalForInorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();

        // Initialize current as the root of the tree
        TreeNode cur = root;

        // Traverse the tree using Morris Inorder Traversal
        while (cur != null) {
            // If the current node's left child is null, add the current node's value to the result
            // and move to the right child.
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                // If the current node has a left child, find the rightmost node in the left subtree
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the rightmost node's right child is null, link it to the current node and move to the left child.
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    // If the rightmost node's right child is not null, unlink it, add the current node's value to the result,
                    // and move to the right child.
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return inorder;
    }
}
