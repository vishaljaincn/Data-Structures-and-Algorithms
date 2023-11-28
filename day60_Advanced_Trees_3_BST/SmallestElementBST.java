package day60_Advanced_Trees_3_BST;
//TC - O(H) = logN
public class SmallestElementBST {
    // Method to find the smallest element in a BST
    public static int findSmallestElement(TreeNode root) {
        // Check if the BST is empty
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }

        // Use a temporary variable for traversal
        TreeNode temp = root;

        // Traverse to the leftmost node (smallest element in BST)
        while (temp.left != null) {
            temp = temp.left;
        }

        // Return the value of the smallest element
        return temp.val;
    }

    // Example usage
    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        // Find and print the smallest element in the BST
        int smallestElement = findSmallestElement(root);
        System.out.println("The smallest element in the BST is: " + smallestElement);
    }
}

