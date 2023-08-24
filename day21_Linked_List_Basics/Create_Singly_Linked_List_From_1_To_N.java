package day21_Linked_List_Basics;
/*
Create a Linked List Of Size N, with values 1 to N, print values of all the nodes and finally return the
starting node(head) of the linked list.
 */

// Definition for singly-linked list.
class ListNode {
    public int val;
    public ListNode next;

    // Constructor to initialize a node with a given value
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Create_Singly_Linked_List_From_1_To_N {
    // Function to create a linked list of size N with values 1 to N,
    // and return the starting node (head) of the linked list.
    public static ListNode createLinkedList(int N) {
        // Create the first node with value 1 as the head of the linked list
        ListNode head = new ListNode(1);
        // Initialize a temporary node to traverse and build the list
        ListNode temp = head;

        // Iterate from 2 to N to create and add nodes to the linked list
        for (int i = 2; i <= N; i++) {
            // Create a new node with the current value
            ListNode newNode = new ListNode(i);
            // Connect the current node's next to the new node
            temp.next = newNode;
            // Move the temp pointer to the newly added node
            temp = temp.next;
        }

        // Reassign temp to the head node to traverse the list and print values
        temp = head;
        // Traverse the linked list and print the values of all nodes
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        // Return the head of the linked list
        return head;
    }

    public static void main(String[] args) {
        // Call the createLinkedList function with a desired N value
        // and print the value of the head node returned by the function
        System.out.println(createLinkedList(5).val);
    }
}
