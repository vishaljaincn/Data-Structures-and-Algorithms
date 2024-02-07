package day50_Advanced_Linked_List_1;

/*
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
*/
class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class MiddleOfALinkedListUsingSlowAndFastPointers_876 {
    // Function to find the middle node of a linked list using slow and fast pointers.
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        // Traverse the list with two pointers, one moving at normal speed (slow)
        // and the other moving at twice the speed (fast).
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // The 'slow' pointer now points to the middle node (or the second middle node in case of an even-length list).
        return slow;
    }
}
