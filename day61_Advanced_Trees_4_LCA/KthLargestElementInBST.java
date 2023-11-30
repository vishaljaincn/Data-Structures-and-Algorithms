package day61_Advanced_Trees_4_LCA;

public class KthLargestElementInBST {
    public int kthLargest(TreeNode root, int k) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.right == null) {
                // If there is no right child, decrement k.
                k--;

                // If k becomes zero, we found the kth largest element.
                if (k == 0) {
                    return curr.val;
                }

                // Move to the left child.
                curr = curr.left;
            } else {
                // If there is a right child, find the inorder predecessor.
                TreeNode pred = curr.right;
                while (pred.left != null && pred.left != curr) {
                    pred = pred.left;
                }

                if (pred.left == null) {
                    // Establish a temporary link from predecessor to current and move to the right child.
                    pred.left = curr;
                    curr = curr.right;
                } else {
                    // Remove the temporary link, decrement k, and move to the left child.
                    pred.left = null;
                    k--;

                    // If k becomes zero, we found the kth largest element.
                    if (k == 0) {
                        return curr.val;
                    }

                    // Move to the left child.
                    curr = curr.left;
                }
            }
        }

        // Return -1 if k is greater than the number of elements in the tree.
        return -1;
    }
}
