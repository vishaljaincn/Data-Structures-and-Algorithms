package day59_Advanced_Contest_5;

/*
you are given two linked lists A and B of size N amd M respectively,
remove linked list A's nodes from C th index to Dth index(0 based indexing, ) and put the list B in their place
 */
class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class MergeLists {
    // Function to merge two linked lists A and B by removing nodes in the range [C, D] from A
    // and inserting them at the position where B starts
    public static ListNode solve(ListNode A, ListNode B, int C, int D) {
        // Create a dummy node to simplify the code
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode currentA = dummy;

        // Move to the node before the starting point (C) in list A
        for (int i = 0; i < C; i++) {
            currentA = currentA.next;
        }

        // Remove nodes from A in the range [C, D]
        ListNode temp = currentA.next;
        for (int i = C; i <= D; i++) {
            temp = temp.next;
        }
        currentA.next = temp; // Connect the previous part of A with the remaining part after removal

        // Find the end of list B
        ListNode endB = B;
        while (endB.next != null) {
            endB = endB.next;
        }

        // Insert nodes from B in the removed range
        currentA.next = B; // Connect the previous part of A with the start of B
        endB.next = temp; // Connect the end of B with the remaining part after removal in A

        return dummy.next; // Return the merged list
    }

    public static void main(String[] args) {
        // Creating a sample linked list A: 1 -> 2 -> 3 -> 4 -> 5
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);

        // Creating a sample linked list B: 6 -> 7 -> 8
        ListNode B = new ListNode(6);
        B.next = new ListNode(7);
        B.next.next = new ListNode(8);

        // Displaying the original linked lists
        System.out.println("Original Linked List A:");
        printLinkedList(A);

        System.out.println("Original Linked List B:");
        printLinkedList(B);

        // Using the solve function to merge lists A and B by removing nodes in the range [2, 4] from A
        int C = 2;
        int D = 3;
        ListNode mergedList = solve(A, B, C, D);

        // Displaying the merged linked list
        System.out.println("Merged Linked List:");
        printLinkedList(mergedList);
    }

    // Helper method to print the elements of a linked list
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
