package day64_Advanced_Heaps_1;

import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        // Create a PriorityQueue (min-heap) of integers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements to the min-heap
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(2);

        // Poll elements from the min-heap and print them
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // Outputs: 1 2 3 4
        }
    }
}
