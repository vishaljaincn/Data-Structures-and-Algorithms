package day50_Advanced_Linked_List_1;
/*
Given a singly linked list containing N nodes, the task is to delete all the even nodes from the list.
 */
// Time: O(n), where n is the number of nodes in the linked list. Space: O(1)

public class DeleteAllEvenNodeFromASinglyLinkedList_GFG {

    // Function to remove nodes at even positions in a linked list in-place
    public static ListNode removeEvenNodes(ListNode head) {
        // Check if the linked list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers to keep track of previous and current nodes
        ListNode prev = head;
        ListNode current = head.next;

        // Traverse the linked list and remove nodes at even positions
        while (current != null && current.next != null) {
            // Update the 'next' reference of the previous node to skip the current node
            prev.next = current.next;
            // Move the 'prev' pointer to the next node in the modified sequence
            prev = current.next;
            // Move the 'current' pointer to the next node at an odd position
            current = current.next.next;
        }

        // Return the head of the modified linked list
        return head;
    }

    // Function to print the elements of a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method for example usage
    public static void main(String[] args) {
        // Example usage
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode linkedList = new ListNode(1);
        linkedList.next = new ListNode(2);
        linkedList.next.next = new ListNode(3);
        linkedList.next.next.next = new ListNode(4);
        linkedList.next.next.next.next = new ListNode(5);

        // Remove even nodes
        ListNode modifiedList = removeEvenNodes(linkedList);

        // Print the modified linked list
        printList(modifiedList);
    }
}
