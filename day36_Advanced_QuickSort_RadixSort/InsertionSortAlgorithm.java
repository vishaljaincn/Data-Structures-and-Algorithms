package day36_Advanced_QuickSort_RadixSort;

import java.util.Arrays;

public class InsertionSortAlgorithm {

    // Function to sort an array using insertion sort
    public static void insertionSort(int arr[]) {
        int n = arr.length;

        // Iterate through the array starting from the second element
        for (int i = 1; i < n; ++i) {
            int key = arr[i]; // Store the current element to be inserted
            int j = i - 1; // Initialize a pointer to the previous element

            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift the larger element to the right
                j--;
            }

            arr[j + 1] = key; // Place the current element (key) in its correct position
        }
    }

    public static void main(String[] args) {
        int A[] = {12, 10, 11, 2, 3, 5, 1};
        insertionSort(A);
        System.out.println(Arrays.toString(A));
    }
}
