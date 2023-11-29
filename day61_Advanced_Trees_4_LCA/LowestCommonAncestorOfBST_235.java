package day61_Advanced_Trees_4_LCA;
//TC - O(H)
//SC - O(1)
class LowestCommonAncestorOfBST_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // If both p and q are smaller than the current root, move to the left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are greater than the current root, move to the right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // If p and q are on either side of the current root, or one of them is the root, the current root is the LCA
            else {
                return root;
            }
        }
        return null; // Return null if no common ancestor is found
    }
}
