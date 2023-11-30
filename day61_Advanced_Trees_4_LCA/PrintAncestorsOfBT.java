package day61_Advanced_Trees_4_LCA;


// Java program to print ancestors of given node

/* A binary tree node has val, pointer to left child
and a pointer to right child */
class PrintAncestorsOfBT {
    TreeNode root;

    /* If target is present in tree, then prints the ancestors
    and returns true, otherwise returns false. */
    static boolean printAncestors(TreeNode node, int target) {
        /* base cases */
        if (node == null)
            return false;

        if (node.val == target)
            return true;

        /* If target is present in either left or right subtree
        of this node, then print this node */
        if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
            System.out.print(node.val + " ");
            return true;
        }

        /* Else return false */
        return false;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        PrintAncestorsOfBT tree = new PrintAncestorsOfBT();

        /* Construct the following binary tree
                1
                / \
            2	 3
            / \
            4 5
            /
        7
        */
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.left.left = new TreeNode(7);

        tree.printAncestors(tree.root, 7);
    }
}
