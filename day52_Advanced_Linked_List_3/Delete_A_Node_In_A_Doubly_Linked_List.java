package day52_Advanced_Linked_List_3;


class DoublyLinkedList1 {
    public ListNode head;
    public ListNode tail;

    public DoublyLinkedList1() {
        this.head = null;
        this.tail = null;
    }

    // Method to delete a node from the doubly linked list and return the new head
    public ListNode deleteNode(ListNode nodeToDelete) {
        if (nodeToDelete == null) {
            return head;
        }

        if (nodeToDelete == head) {
            head = nodeToDelete.next;
        }

        if (nodeToDelete == tail) {
            tail = nodeToDelete.prev;
        }

        if (nodeToDelete.prev != null) {
            nodeToDelete.prev.next = nodeToDelete.next;
        }

        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = nodeToDelete.prev;
        }

        return head;
    }

    // Method to add a node to the end of the doubly linked list
    public void append(int data) {
        ListNode newNode = new ListNode(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to display the doubly linked list
    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Delete_A_Node_In_A_Doubly_Linked_List {
    public static void main(String[] args) {
        DoublyLinkedList1 list = new DoublyLinkedList1();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("Original Doubly Linked List:");
        list.display();

        ListNode nodeToDelete = list.head.next; // Delete the second node (with data 2)
        list.head = list.deleteNode(nodeToDelete);

        System.out.println("Doubly Linked List after deleting the node:");
        list.display();
    }
}
