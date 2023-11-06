package day54_Advanced_Stacks_1;

public class StackUsingArray {
    private int maxSize;     // Maximum size of the stack
    private int[] stackArray; // Array to hold the stack elements
    private int top;          // Index of the top element

    public StackUsingArray(int size) {
        maxSize = size;          // Initialize the maximum size
        stackArray = new int[maxSize]; // Create the array with the specified size
        top = -1;                 // Initialize the top index to -1 (empty stack)
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stackArray[++top] = value; // Increment the top index and add the value to the stack
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // You can choose a different value or throw an exception if you prefer.
        }
        return stackArray[top--]; // Return and decrement the top index
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // You can choose a different value or throw an exception if you prefer.
        }
        return stackArray[top]; // Return the top element without removing it
    }

    public boolean isEmpty() {
        return (top == -1); // Check if the stack is empty (top index is -1)
    }

    public boolean isFull() {
        return (top == maxSize - 1); // Check if the stack is full (top index is at the maximum)
    }

    public int size() {
        return top + 1; // Calculate the size of the stack (number of elements)
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek());

        stack.pop();
        System.out.println("Top element after pop: " + stack.peek());

        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Is the stack full? " + stack.isFull());
        System.out.println("Stack size: " + stack.size());
    }
}
