package day56_Advaned_Queues;

import java.util.Stack;


public class ImplementQueuesUsingStacks {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueuesUsingStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    // Time complexity: O(1)
    public void push(int x) {
        enqueueStack.push(x);
    }

    /**
     * Removes the element from in front of the queue and returns that element.
     */
    // Time complexity: O(1) Amortized/Average
    public int pop() {
        if (dequeueStack.isEmpty()) {
            transferElements();
        }
        return dequeueStack.pop();
    }

    /**
     * Get the front element.
     */
    // Time complexity: O(1) Amortized/Average
    public int peek() {
        if (dequeueStack.isEmpty()) {
            transferElements();
        }
        return dequeueStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    // Time complexity: O(1)
    public boolean empty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    // Helper method to transfer elements from enqueueStack to dequeueStack
    // Time complexity: O(n), where n is the number of elements in enqueueStack
    private void transferElements() {
        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }
    }
}
