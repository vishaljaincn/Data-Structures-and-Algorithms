package day56_Advaned_Queues;

import java.util.ArrayList;

public class QueueUsingDynamicArray {
    // ArrayList to store the elements of the queue
    private ArrayList<Integer> array;

    // Variables to keep track of the front and rear of the queue
    private int front;
    private int rear;

    // Constructor to initialize the queue
    public QueueUsingDynamicArray() {
        this.array = new ArrayList<>();
        this.front = 0;
        this.rear = -1;
    }

    // Method to enqueue (add) an item to the queue
    // Time Complexity: O(1)
    public void enqueue(int item) {
        rear++;
        array.add(item);
    }

    // Method to dequeue (remove) an item from the queue
    // Time Complexity: O(1)
    public int dequeue() {
        // Check if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int item = array.get(front);
        front++;
        return item;
    }

    // Method to peek at the front element of the queue without removing it
    // Time Complexity: O(1)
    public int peek() {
        // Check if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }

        return array.get(front);
    }

    // Method to check if the queue is empty
    // Time Complexity: O(1)
    public boolean isEmpty() {
        return front > rear;
    }

    // Method to get the size of the queue
    // Time Complexity: O(1)
    public int size() {
        return rear - front + 1;
    }

    // Main method for testing the queue implementation
    public static void main(String[] args) {
        // Create a new DynamicArrayQueue
        QueueUsingDynamicArray queue = new QueueUsingDynamicArray();

        // Enqueue some elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue an element and peek at the front
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());

        // Enqueue another element and display the size
        queue.enqueue(4);
        System.out.println("Size: " + queue.size());
    }
}
