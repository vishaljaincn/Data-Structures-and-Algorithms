package day56_Advaned_Queues;

import java.util.LinkedList;
import java.util.Queue;

/*
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:
void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.

Notes:
You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 */
class ImplementStacksUsingQueues_225 {
    private Queue<Integer> mainQueue;
    private Queue<Integer> auxiliaryQueue;

    /**
     * Initialize your data structure here.
     */
    public ImplementStacksUsingQueues_225() {
        mainQueue = new LinkedList<>();
        auxiliaryQueue = new LinkedList<>();
    }

    /**
     * Push element x onto the stack.
     * Time complexity: O(n)
     */
    public void push(int x) {
        // Move all elements from mainQueue to auxiliaryQueue
        while (!mainQueue.isEmpty()) {
            auxiliaryQueue.offer(mainQueue.poll());
        }

        // Enqueue the new element to mainQueue
        mainQueue.offer(x);

        // Move elements back from auxiliaryQueue to mainQueue
        while (!auxiliaryQueue.isEmpty()) {
            mainQueue.offer(auxiliaryQueue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     * Time complexity: O(1)
     */
    public int pop() {
        // Dequeue the top element from mainQueue
        return mainQueue.poll();
    }

    /**
     * Get the top element.
     * Time complexity: O(1)
     */
    public int top() {
        // Peek the top element from mainQueue
        return mainQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     * Time complexity: O(1)
     */
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}
