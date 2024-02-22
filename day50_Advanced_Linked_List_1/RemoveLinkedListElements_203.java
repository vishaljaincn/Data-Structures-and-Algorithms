package day50_Advanced_Linked_List_1;

/*
Given the head of a linked list and an integer val, remove all the nodes of the
linked list that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []
 */

class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node with an arbitrary value (in this case, -1)
        ListNode dummy = new ListNode(-1);

        // Set the next of the dummy node to be the head of the original list
        dummy.next = head;

        // Initialize a temporary pointer to the dummy node
        ListNode temp = dummy;

        // Iterate through the list
        while (temp != null && temp.next != null) {
            // Check if the next node has the target value
            if (temp.next.value == val) {
                // Skip the next node by updating the next pointer
                temp.next = temp.next.next;
            } else {
                // Move the temporary pointer forward
                temp = temp.next;
            }
        }

        // Return the updated list starting from dummy.next
        return dummy.next;
    }
}
