package day37_comparator_and_problems;// Importing the Arrays class to use the toString method for printing arrays

import java.util.Arrays;

public class BubbleSortAlgorithm {

    // Function to perform Bubble Sort
    public static void bubbleSort(int A[]) {
        int n = A.length; // Get the length of the array

        // Outer loop: Iterate through each element in the array
        for (int i = 0; i < n; i++) {

            // Inner loop: Compare and swap adjacent elements
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    // Swap the elements if they are in the wrong order
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int A[] = {3, 2, 5, 6, 4, 1};

        // Call the bubbleSort function to sort the array
        bubbleSort(A);

        // Print the sorted array using Arrays.toString method
        System.out.println(Arrays.toString(A));
    }
}
