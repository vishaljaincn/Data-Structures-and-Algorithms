package day52_Advanced_Linked_List_3;

class ListNode {
    int data;
    ListNode prev;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    ListNode head;

    // Insert a node at the beginning of the doubly linked list
    public ListNode insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
        return head;
    }

    // Insert a node at the end of the doubly linked list
    public ListNode insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = null;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return head;
        }

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;
        return head;
    }

    // Insert a node after a specific node in the doubly linked list
    public ListNode insertAfter(ListNode prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node can't be null.");
            return head;
        }

        ListNode newNode = new ListNode(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }

        return head;
    }

    // Display the contents of the doubly linked list
    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Insert_A_Node_In_A_Doubly_Linked_List {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Inserting elements into the doubly linked list
        list.insertAtEnd(1);              // Insert 1 at the end
        list.insertAtBeginning(2);        // Insert 2 at the beginning
        list.insertAtEnd(3);              // Insert 3 at the end
        list.insertAfter(list.head.next, 4);  // Insert 4 after the second element

        System.out.println("Doubly Linked List:");
        list.display();                   // Display the doubly linked list
    }
}
