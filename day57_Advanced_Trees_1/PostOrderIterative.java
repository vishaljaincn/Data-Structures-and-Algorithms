package day57_Advanced_Trees_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PostOrderIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        // Initialize the current node as the root
        TreeNode current = root;

        // Check if the tree is empty
        if (current == null)
            return new ArrayList<>();

        // List to store the result of the traversal
        List<Integer> ans = new ArrayList<>();

        // Stack to keep track of nodes during traversal
        Stack<TreeNode> stack = new Stack<>();

        // Start with the root node
        stack.push(current);

        // Perform iterative postorder traversal
        while (!stack.isEmpty()) {
            // Get the current node from the stack
            current = stack.pop();

            // Add the value of the current node to the result list
            ans.add(current.val);

            // Push the left and right children onto the stack
            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }

        // Reverse the result list to get the final postorder traversal order
        Collections.reverse(ans);

        // Return the final result
        return ans;
    }
}


