package day36_Advanced_QuickSort_RadixSort;

import java.util.Arrays;

/*
All elements are sorted from 0 to N minus 1; insert the last element in the correct order."
 */

public class AllElementsAreSortedFrom0toN_minus_1_Insert_The_Last_Element_In_The_Correct_Order {
    // Function to insert the last element in its correct sorted position
    public static void solve(int[] A) {
        int n = A.length;
        int key = A[n - 1]; // Store the last element to be inserted
        int i = n - 2; // Start from the second-to-last element

        // Move elements greater than the key to the right
        while (i >= 0 && A[i] > key) {
            A[i + 1] = A[i]; // Shift the larger element to the right
            i--;
        }

        A[i + 1] = key; // Place the last element (key) in its correct sorted position
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 5, 6, 7, 4}; // Example input array
        solve(A); // Insert the last element in sorted order
        System.out.println(Arrays.toString(A)); // Print the modified array
    }
}
