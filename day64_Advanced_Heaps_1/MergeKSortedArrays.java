package day64_Advanced_Heaps_1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    // Element class to represent each element with its value, array index, and element index
    static class Element implements Comparable<Element> {
        int value;          // Value of the element
        int arrayIndex;     // Index of the array containing the element
        int elementIndex;   // Index of the element within the array

        Element(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Create a min heap using PriorityQueue to efficiently track the smallest elements
        PriorityQueue<Element> minHeap = new PriorityQueue<>();

        // Populate the heap with the first element from each array along with the array index
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            if (!array.isEmpty()) {
                minHeap.offer(new Element(array.get(0), i, 0));
            }
        }

        // Result list to store the merged elements
        List<Integer> result = new ArrayList<>();

        // Continue until the heap is empty
        while (!minHeap.isEmpty()) {
            // Poll the smallest element from the heap
            Element current = minHeap.poll();

            // Add the smallest element to the result
            result.add(current.value);

            // Move to the next element in the array
            if (current.elementIndex + 1 < arrays.get(current.arrayIndex).size()) {
                int nextElement = arrays.get(current.arrayIndex).get(current.elementIndex + 1);
                minHeap.offer(new Element(nextElement, current.arrayIndex, current.elementIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> array1 = List.of(1, 3, 5, 7);
        List<Integer> array2 = List.of(2, 4, 6, 8);
        List<Integer> array3 = List.of(0, 9, 10, 11);

        List<List<Integer>> arrays = List.of(array1, array2, array3);

        // Merge the sorted arrays
        List<Integer> mergedResult = mergeSortedArrays(arrays);

        // Print the merged result
        System.out.println("Merged Result: " + mergedResult);
    }
}
