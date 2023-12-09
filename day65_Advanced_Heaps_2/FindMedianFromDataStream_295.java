package day65_Advanced_Heaps_2;

import java.util.PriorityQueue;

/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
// Class for finding the median of a data stream
class FindMedianFromDataStream_295 {
    // Priority queues to store the smaller and larger halves of elements
    private PriorityQueue<Integer> maxHeap; // to store the smaller half of elements
    private PriorityQueue<Integer> minHeap; // to store the larger half of elements

    // Constructor to initialize the data structure
    public FindMedianFromDataStream_295() {
        // Max heap to store the smaller half with a custom comparator for reverse ordering
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Min heap to store the larger half
        minHeap = new PriorityQueue<>();
    }

    // Method to add a number to the data stream
    public void addNum(int num) {
        // Add to the appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Get the sizes of both heaps
        int size1 = maxHeap.size();
        int size2 = minHeap.size();

        // Balance the heaps if their sizes differ by more than 1
        if (size1 - size2 > 1) {
            int element = maxHeap.poll();
            minHeap.offer(element);
        } else if (size2 - size1 > 0) {
            int element = minHeap.poll();
            maxHeap.offer(element);
        }
    }

    // Method to find the median of the data stream
    public double findMedian() {
        // Check if the heaps have equal size
        if (maxHeap.size() == minHeap.size()) {
            // Return the average of the tops of both heaps
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // Return the top of the max heap (larger half)
            return maxHeap.peek();
        }
    }
}

