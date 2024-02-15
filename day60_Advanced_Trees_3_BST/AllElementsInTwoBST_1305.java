package day60_Advanced_Trees_3_BST;

import java.util.ArrayList;
import java.util.List;

/*
Given two binary search trees root1 and root2, return a list containing all the integers from both trees
sorted in ascending order.
Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 */
// Time Complexity: O(m + n), where m and n are the number of nodes in the two binary search trees.
// Space Complexity: O(m + n), where m and n are the number of nodes in the two binary search trees
// (for storing lists).
public class AllElementsInTwoBST_1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Perform inorder traversal on the first tree and add elements to list1
        inorderTraversal(root1, list1);

        // Perform inorder traversal on the second tree and add elements to list2
        inorderTraversal(root2, list2);

        // Merge the sorted lists list1 and list2 into the result list
        mergeLists(list1, list2, result);

        // Return the final result list
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return; // Base case: reached a null node, return
        }

        // Traverse left subtree
        inorderTraversal(root.left, list);

        // Add the current node's value to the list
        list.add(root.val);

        // Traverse right subtree
        inorderTraversal(root.right, list);
    }

    private void mergeLists(List<Integer> list1, List<Integer> list2, List<Integer> result) {
        int i = 0, j = 0;

        // Merge elements from list1 and list2 into the result list
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements from list1, if any
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }

        // Add remaining elements from list2, if any
        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }
    }
}
