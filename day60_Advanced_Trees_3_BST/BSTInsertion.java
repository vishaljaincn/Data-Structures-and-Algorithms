package day60_Advanced_Trees_3_BST;
//TC - O(H) = logN
public class BSTInsertion {
    // Method to insert a key into the BST iteratively
    public static TreeNode insert(TreeNode root, int key) {
        // If the tree is empty, create a new node as the root
        if (root == null) {
            return new TreeNode(key);
        }

        // Use a temporary variable for traversal
        TreeNode temp = root;

        // Traverse the tree to find the appropriate spot for insertion
        while (temp != null) {
            if (key < temp.val) {
                // If the left child is null, insert the new node, else move to the left subtree
                if (temp.left == null) {
                    temp.left = new TreeNode(key);
                    break;
                } else {
                    temp = temp.left;
                }
            } else if (key > temp.val) {
                // If the right child is null, insert the new node, else move to the right subtree
                if (temp.right == null) {
                    temp.right = new TreeNode(key);
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                // If the key is already present, handle it as needed
                break;
            }
        }

        return root;
    }

    // Example usage
    public static void main(String[] args) {
        // Create an empty BST
        TreeNode root = null;

        // Insert some nodes into the BST
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);
    }
}
