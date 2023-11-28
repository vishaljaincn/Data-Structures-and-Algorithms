package day60_Advanced_Trees_3_BST;
//TC - O(H) = logN
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int key) {
        val = key;
        left = right = null;
    }
}

public class LargestElementBST {
    // Method to find the largest element in a BST
    public static int findLargestElement(TreeNode root) {
        // Check if the BST is empty
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }

        // Use a temporary variable for traversal
        TreeNode temp = root;

        // Traverse to the rightmost node (largest element in BST)
        while (temp.right != null) {
            temp = temp.right;
        }

        // Return the value of the largest element
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

        // Find and print the largest element in the BST
        int largestElement = findLargestElement(root);
        System.out.println("The largest element in the BST is: " + largestElement);
    }
}

