package day51_Advanced_Linked_List_2;

/*
Given a linked list of N nodes such that it may contain a loop.

A loop here means that the last node of the link list is connected to the node at position X(1-based index).
If the link list does not have any loop, X=0.

Remove the loop from the linked list, if it is present, i.e. unlink the last node which is forming the loop.
 */
public class RemoveCycle_Or_Loop_From_Linked_List {
    public ListNode removeLoop(ListNode head) {
        // Check if the list is empty or has only one node, in which case there can be no loop.
        if (head == null || head.next == null) {
            return head; // No loop if the list is empty or has only one node.
        }

        // Initialize two pointers, slow and fast, and a flag to track if a cycle is found.
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Detect the loop using Floyd's Cycle Detection Algorithm.
        while (fast != null && fast.next != null) {
            slow = slow.next;     // Move the slow pointer one step at a time.
            fast = fast.next.next; // Move the fast pointer two steps at a time.

            // If the slow and fast pointers meet, a cycle is found.
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // If there's no cycle, return the original head.
        if (!hasCycle) {
            return head; // If there's no loop, return the original head.
        }

        // Move one pointer to the beginning and keep the other pointer at the meeting point.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both pointers will meet at the start of the loop.
        // Find the last node of the loop.
        ListNode lastInLoop = slow;
        while (lastInLoop.next != slow) {
            lastInLoop = lastInLoop.next;
        }

        // Break the loop by setting the last node's next to null.
        lastInLoop.next = null;

        // Return the head of the linked list with the loop removed.
        return head;
    }
}


