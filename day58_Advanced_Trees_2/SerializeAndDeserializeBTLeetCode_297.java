package day58_Advanced_Trees_2;
/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBTLeetCode_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        // Add the root node to the queue to start level order traversal
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Check if the current node is null
            if (node == null) {
                res.append("null "); // Append "null" to the result for a null node
            } else {
                res.append(node.val).append(" "); // Append the value of the current node to the result
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Check if the input data is empty
        if (data == "") return null;

        // Split the input data into an array of values
        String[] values = data.split(" ");

        // Create a queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Create the root node using the first value in the array
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        // Iterate through the array starting from index 1
        for (int i = 1; i < values.length; i++) {
            // Retrieve the parent node from the queue
            TreeNode parent = queue.poll();

            // Create the left child if the value is not null
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }

            // Move to the next index
            i++;

            // Create the right child if the value is not null and update the queue
            if (i < values.length && !values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }

        // Return the root of the constructed binary tree
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
