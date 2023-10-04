package day38_Advanced_DSA_Binary_Search;

/*
Given an array of integers A sorted in ascending order, find the starting index of a given target value.

If target is not found in the array, return -1

You must write an algorithm with O(log n) runtime complexity.
 */
public class FirstOccurrenceIndexOfGivenElement {
    public static int findStartingIndex(int[] A, int k) {
        int low = 0;            // Initialize the lower bound of the search range
        int high = A.length - 1; // Initialize the upper bound of the search range
        int result = -1;           // Initialize the result to -1

        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index of the current search range

            if (A[mid] == k) {
                result = mid;  // Update the result if the target is found but continue searching to the left
                high = mid - 1; // Adjust the search range to the left of mid
            } else if (A[mid] < k) {
                low = mid + 1; // Adjust the search range to the right of mid
            } else {
                high = mid - 1; // Adjust the search range to the left of mid
            }
        }

        return result; // Return the final result, which is the starting index of the target if found, or -1 if not found
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 2, 3, 4, 5};
        int k = 2;
        int result = findStartingIndex(A, k);
        System.out.println(result);  // Output: 1 (the first occurrence of 2 in the array)
    }
}


