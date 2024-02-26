package day64_Advanced_Heaps_1;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
 */

// Time complexity: O(log k) for each 'add' operation, where k is the size of the heap.
// Space complexity: O(k), the space used by the priority queue to store the k smallest elements.

import java.util.PriorityQueue;

class KthLargestElementInA_Stream_703 {
    private final PriorityQueue<Integer> minHeap; // Priority queue to maintain the k smallest elements
    private final int k; // Size of the heap (kth largest element)

    // Constructor to initialize the KthLargest object
    public KthLargestElementInA_Stream_703(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k); // Initialize min heap with size k

        // Populate the min heap with initial elements from the nums array
        for (int num : nums) {
            add(num);
        }
    }

    // Method to add a new element to the stream and return the kth largest element
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val); // If heap size is less than k, directly add the new element
        } else if (val > minHeap.peek()) {
            minHeap.poll(); // Remove the smallest element (top of min heap) as it will be replaced
            minHeap.offer(val); // Add the new element to the heap
        }

        return minHeap.peek(); // Return the current kth largest element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */