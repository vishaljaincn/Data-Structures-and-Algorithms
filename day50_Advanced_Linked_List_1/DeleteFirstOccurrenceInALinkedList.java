package day50_Advanced_Linked_List_1;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class DeleteFirstOccurrenceInALinkedList {
    public Node delete_node(Node head, int value) {
        // If the linked list is empty, there's nothing to delete, so return the original head.
        if (head == null) {
            return head;
        }

        // If the value to be deleted is at the head of the linked list, update the head to the next node.
        if (head.value == value) {
            head = head.next;
            return head;
        }

        // Traverse the linked list to find the node with the specified value and delete it.
        Node temp = head;
        while (temp.next != null) {
            // If the value of the next node matches the target value, update the references to skip it.
            if (temp.next.value == value) {
                temp.next = temp.next.next;
                return head; // Return the updated head.
            }
            temp = temp.next; // Move to the next node in the linked list.
        }

        // If the value was not found in the linked list, return the original head.
        return head;
    }


    public static void main(String[] args) {
        // Create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        DeleteFirstOccurrenceInALinkedList solution = new DeleteFirstOccurrenceInALinkedList();

        System.out.println("Original Linked List:");
        printLinkedList(head);

        int valueToDelete = 3;
        head = solution.delete_node(head, valueToDelete);

        System.out.println("Linked List after deleting the first occurrence of " + valueToDelete + ":");
        printLinkedList(head);
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
