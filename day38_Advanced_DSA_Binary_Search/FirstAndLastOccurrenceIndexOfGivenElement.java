package day38_Advanced_DSA_Binary_Search;

import java.util.Arrays;

/*
Given an array of integers A sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
 */
public class FirstAndLastOccurrenceIndexOfGivenElement {
    public static int[] searchRange(int[] A, int k) {
        int[] result = new int[2];
        result[0] = findFirst(A, k); // Find the first occurrence of k.
        result[1] = findLast(A, k);  // Find the last occurrence of k.
        return result;
    }

    // Helper function to find the first occurrence of k in the sorted array A.
    private static int findFirst(int[] A, int k) {
        int low = 0;            // Initialize the lower bound of the search range
        int high = A.length - 1; // Initialize the upper bound of the search range
        int result = -1;        // Initialize the result to -1

        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index of the current search range

            if (A[mid] == k) {
                result = mid;     // Update the result if the target is found
                high = mid - 1;   // Continue searching to the left of mid for the first occurrence
            } else if (A[mid] < k) {
                low = mid + 1;    // Adjust the search range to the right of mid
            } else {
                high = mid - 1;   // Adjust the search range to the left of mid
            }
        }

        return result; // Return the final result, which is the starting index of the target if found, or -1 if not found
    }

    // Helper function to find the last occurrence of k in the sorted array A.
    private static int findLast(int[] A, int k) {
        int low = 0;            // Initialize the lower bound of the search range
        int high = A.length - 1; // Initialize the upper bound of the search range
        int result = -1;        // Initialize the result to -1

        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index of the current search range

            if (A[mid] == k) {
                result = mid;     // Update the result if the target is found
                low = mid + 1;    // Continue searching to the right of mid for the last occurrence
            } else if (A[mid] < k) {
                low = mid + 1;    // Adjust the search range to the right of mid
            } else {
                high = mid - 1;   // Adjust the search range to the left of mid
            }
        }

        return result; // Return the final result, which is the ending index of the target if found, or -1 if not found
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 4, 4, 4, 5, 6, 7};
        int k = 4;
        System.out.println(Arrays.toString(searchRange(A, k)));
    }
}


