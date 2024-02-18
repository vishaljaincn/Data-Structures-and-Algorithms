package day50_Advanced_Linked_List_1;

/*
Given the head of a linked list, rotate the list to the right by k places.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Time complexity: O(N), where N is the length of the linked list
// Space complexity: O(1)

public class RotateListBy_K_Places_61 {
    public ListNode rotateRight(ListNode head, int k) {
        // Check for empty list or k equal to 0
        if (head == null || k == 0) {
            return head;
        }

        // Calculate the length of the linked list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Adjust k if it's greater than the length of the linked list
        k = k % length;

        // If k is 0 after adjustment, no rotation needed
        if (k == 0) {
            return head;
        }

        // Find the new tail and head after rotation
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null; // Set the new tail's next to null

        // Connect the original tail to the original head to form the rotated list
        tail.next = head;

        return newHead;
    }
}
