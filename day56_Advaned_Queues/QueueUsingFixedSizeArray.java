package day56_Advaned_Queues;

class Queue {

    private int arr[];
    private int front, rear, currSize, maxSize;

    // Default constructor with a default size of 16
    public Queue() {
        arr = new int[16];
        front = -1;
        rear = -1;
        currSize = 0;
    }

    // Parameterized constructor to set the maximum size of the queue
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
        currSize = 0;
    }

    // Add a new element to the end of the queue (enqueue)
    public void push(int newElement) {
        // Check if the queue is full
        if (currSize == maxSize) {
            System.out.println("Queue is full. Exiting...");
        }

        // Initialize the queue if it's empty
        if (rear == -1) {
            front = 0;
            rear = 0;
        } else {
            // Move the rear pointer to the next position, considering circular array
            rear = (rear + 1) % maxSize;
        }

        // Add the new element to the end of the queue
        arr[rear] = newElement;
        System.out.println("The element pushed is " + newElement);
        currSize++;
    }

    // Remove and return the front element from the queue (dequeue)
    public int pop() {
        // Check if the queue is empty
        if (front == -1) {
            System.out.println("Queue Empty. Exiting...");
        }

        // Retrieve the front element
        int popped = arr[front];

        // Adjust pointers if there is only one element in the queue
        if (currSize == 1) {
            front = -1;
            rear = -1;
        } else {
            // Move the front pointer to the next position, considering circular array
            front = (front + 1) % maxSize;
        }

        // Decrease the current size of the queue
        currSize--;

        // Return the popped element
        return popped;
    }

    // Return the front element without removing it
    public int top() {
        // Check if the queue is empty
        if (front == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }

        // Return the front element
        return arr[front];
    }

    // Return the current size of the queue
    public int size() {
        return currSize;
    }
}

public class QueueUsingFixedSizeArray {
    public static void main(String args[]) {
        // Create a queue with a maximum size of 6
        Queue q = new Queue(6);

        // Enqueue elements into the queue
        q.push(4);
        q.push(14);
        q.push(24);
        q.push(34);

        // Display information about the queue before and after dequeue operations
        System.out.println("The peek of the queue before deleting any element " + q.top());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.pop());
        System.out.println("The peek of the queue after deleting an element " + q.top());
        System.out.println("The size of the queue after deleting an element " + q.size());
    }
}
