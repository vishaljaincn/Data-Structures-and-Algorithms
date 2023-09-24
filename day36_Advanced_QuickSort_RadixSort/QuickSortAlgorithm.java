package day36_Advanced_QuickSort_RadixSort;

import java.util.Arrays;
public class QuickSortAlgorithm {

    // Partition the array and return the pivot index
    public static int partition(int[] A, int start, int end) {
        int pivot = A[start]; // Choose the pivot element (usually the first element)
        int p1 = start + 1;   // Initialize the left pointer
        int p2 = end;         // Initialize the right pointer

        while (p1 <= p2) {
            if (A[p1] <= pivot) {
                p1++; // Move the left pointer to the right
            } else if (A[p2] > pivot) {
                p2--; // Move the right pointer to the left
            } else {
                // Swap A[p1] and A[p2] to ensure elements less than pivot are on the left
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                p1++; // Move both pointers towards each other
                p2--;
            }
        }

        // Swap pivot with A[p2] to place the pivot in its final sorted position
        A[start] = A[p2];
        A[p2] = pivot;
        return p2; // Return the pivot index
    }

    // Perform QuickSort on the array
    public static void quickSort(int[] A, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(A, start, end); // Get the pivot index
            quickSort(A, start, partitionIndex - 1);        // Recursively sort the left subarray
            quickSort(A, partitionIndex + 1, end);          // Recursively sort the right subarray
        }
    }

    // Main method to test QuickSort
    public static void main(String[] args) {
        int A[] = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14};
        quickSort(A, 0, A.length - 1); // Rearrange the array using QuickSort
        System.out.println(Arrays.toString(A)); // Print the sorted array
    }
}
