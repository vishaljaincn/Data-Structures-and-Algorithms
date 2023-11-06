package day54_Advanced_Stacks_1;

// Definition of a ListNode to be used in the linked list
class ListNode {
    int data;     // Data stored in the node
    ListNode next;    // Reference to the next node in the linked list

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList {
    private ListNode head; // Reference to the top node in the stack

    // Constructor to initialize an empty stack
    public StackUsingLinkedList() {
        head = null;
    }

    // Method to push (add) a new element onto the stack
    public void push(int value) {
        ListNode newNode = new ListNode(value); // Create a new node with the provided value
        if (head == null) {
            head = newNode; // If the stack is empty, make the new node the head
        } else {
            newNode.next = head; // Link the new node to the current head node
            head = newNode;      // Update the head to be the new node
        }
    }

    // Method to pop (remove) the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // You can choose a different value or throw an exception if you prefer.
        }
        int poppedValue = head.data; // Get the data from the head node
        head = head.next;            // Update the head to the next node in the list
        return poppedValue;          // Return the popped value
    }

    // Method to peek (view) the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // You can choose a different value or throw an exception if you prefer.
        }
        return head.data; // Return the data of the head node
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return head == null; // If the head is null, the stack is empty
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek());

        stack.pop();
        System.out.println("Top element after pop: " + stack.peek());

        System.out.println("Is the stack empty? " + stack.isEmpty());
    }
}
