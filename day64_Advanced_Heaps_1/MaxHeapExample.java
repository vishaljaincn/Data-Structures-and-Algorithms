package day64_Advanced_Heaps_1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeapExample {
    public static void main(String[] args) {
        // Create a PriorityQueue (max-heap) of integers with a custom comparator to reverse natural ordering
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Add elements to the max-heap
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(4);
        maxHeap.add(2);

        // Poll elements from the max-heap and print them
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll()); // Outputs: 4 3 2 1
        }
    }
}

