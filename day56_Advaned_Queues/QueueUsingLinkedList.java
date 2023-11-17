package day56_Advaned_Queues;

// ListNode class represents an element in the linked list
class ListNode {
    int data;
    ListNode next;

    // Constructor to initialize a new node with given data
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class implements a queue using a linked list
class QueueUsingLinkedList {
    private ListNode front, rear;

    // Constructor to initialize an empty queue
    public QueueUsingLinkedList() {
        this.front = this.rear = null;
    }

    // Method to add an element to the queue
    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);

        // If the queue is empty, set front and rear to the new node
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }

        // Otherwise, add the new node to the rear and update rear
        rear.next = newNode;
        rear = newNode;
    }

    // Method to remove an element from the queue
    public int dequeue() {
        // If the queue is empty, return -1 (or throw an exception)
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Otherwise, remove the front node and update front
        int data = front.data;
        front = front.next;

        // If front becomes null, update rear to null as well
        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to get the front element without removing it
    public int peek() {
        // If the queue is empty, return -1 (or throw an exception)
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.data;
    }

    // Example usage of the Queue class
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}
