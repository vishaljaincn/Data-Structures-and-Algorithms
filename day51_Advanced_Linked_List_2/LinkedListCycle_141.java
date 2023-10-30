package day51_Advanced_Linked_List_2;
/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */
class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or has only one node.
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;      // Move the slow pointer one step.
            fast = fast.next.next; // Move the fast pointer two steps.

            if (slow == fast) {
                return true; // If they meet, there's a cycle.
            }
        }

        return false; // If fast reaches the end, there's no cycle.
    }
}
