package day61_Advanced_Trees_4_LCA;
//TC - O(N)
//SC - O(N)
class LowestCommonAncestorOfBT_236 {
    // Function to find the lowest common ancestor of nodes p and q in a binary tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the root is null or if either p or q is the root, return the root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search for p and q in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Result:
        // If either p or q is found in one of the subtrees, return that subtree's result
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            // If both p and q are found in different subtrees, the current root is the lowest common ancestor
            return root;
        }
    }
}
