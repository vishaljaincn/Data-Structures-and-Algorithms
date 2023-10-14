package day44_Advanced_Contest_3;

import java.util.HashSet;
import java.util.Set;

/*
you're given an unique array A and an integer B, In 1 operation, you can pick2 numbers from the array whose sum equals B
and remove them from the array, Return the maximum no of operations you can perform on the array
 */

public class MaximumOperationsUnique {

    public static int solve(int[] A, int B) {
        // Create a HashSet to store unique numbers from the array.
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : A) {
            uniqueNumbers.add(num);
        }

        // Initialize the operations count to 0.
        int operations = 0;

        // Iterate through the original array A.
        for (int num : A) {
            // Calculate the complement of the current number.
            int complement = B - num;

            // Check if the complement exists in the uniqueNumbers set.
            if (uniqueNumbers.contains(complement)) {
                // If a pair is found, increment the operations count.
                operations++;

                // Remove the pair from the set to prevent using them again.
                uniqueNumbers.remove(num);
                uniqueNumbers.remove(complement);
            }
        }

        // Return the maximum number of operations that can be performed.
        return operations;
    }

    public static void main(String[] args) {
        // Example usage
        int[] array = {2, 5, 3, 4};
        int targetSum = 7;
        int maxOperations = solve(array, targetSum);
        System.out.println("Maximum operations: " + maxOperations);
    }
}
