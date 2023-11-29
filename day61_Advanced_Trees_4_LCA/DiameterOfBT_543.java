package day61_Advanced_Trees_4_LCA;
//TC - O(N)
//SC - O(H)
class DiameterOfBT_543 {
    // Variable to store the diameter of the binary tree
    int diameter = 0;

    // Main function to calculate the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        // Call the helper function to perform the actual calculation
        calculateDiameter(root);
        // Return the final diameter
        return diameter;
    }

    // Helper function to recursively calculate the height of each subtree and update the diameter
    private int calculateDiameter(TreeNode node) {
        // Base case: If the current node is null, return 0
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of the left subtree
        int leftHeight = calculateDiameter(node.left);

        // Recursively calculate the height of the right subtree
        int rightHeight = calculateDiameter(node.right);

        // Update the diameter if the sum of heights for the left and right subtrees is greater
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
