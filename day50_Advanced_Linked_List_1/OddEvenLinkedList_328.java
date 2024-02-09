package day50_Advanced_Linked_List_1;
/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 */
//O(1) - space complexity and O(n) - time complexity.

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
class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        // Check if the list is empty or contains only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers for odd and even nodes
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;

        // Iterate through the list, rearranging nodes based on their indices
        while (evenTail != null && evenTail.next != null) {
            // Connect odd nodes
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;

            // Connect even nodes
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        // Connect odd tail to the head of the even list
        oddTail.next = evenHead;

        // Return the modified linked list
        return oddHead;
    }
}
