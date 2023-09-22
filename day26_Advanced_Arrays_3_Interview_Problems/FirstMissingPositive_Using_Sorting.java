package day26_Advanced_Arrays_3_Interview_Problems;

import java.util.Arrays;

public class FirstMissingPositive_Using_Sorting {
    // This method finds the first missing positive integer in an array.
    public static int firstMissingPositive(int[] A) {
        int n = A.length;

        // Step 1: Sort the array to ensure positive integers are in ascending order.
        Arrays.sort(A);

        int missing = 1; // Initialize the missing integer to 1.

        // Step 2: Iterate through the sorted array to find the first missing positive integer.
        for (int i = 0; i < n; i++) {
            if (A[i] == missing) {
                missing++; // Found the next positive integer in its correct position.
            }
        }

        return missing; // Return the first missing positive integer.
    }

    public static void main(String[] args) {
        int[] A = {3, 4, -1, 1}; // Example input
        int result = firstMissingPositive(A);

        // Display the result.
        System.out.println("The first missing positive integer is: " + result);
    }
}
