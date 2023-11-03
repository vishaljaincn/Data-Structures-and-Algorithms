package day51_Advanced_Linked_List_2;

/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.
 */

public class LinkedListCycle2_142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle if the list is empty or has only one node.
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;      // Move the slow pointer one step.
            fast = fast.next.next; // Move the fast pointer two steps.

            if (slow == fast) {
                hasCycle = true; // If they meet, there's a cycle.
                break;
            }
        }

        if (!hasCycle) {
            return head; // If there's no cycle, return head.
        }

        // Move one pointer to the beginning and keep the other pointer at the meeting point.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both pointers will meet at the start of the cycle.
        return slow;
    }
}


