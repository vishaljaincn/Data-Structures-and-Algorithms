package day44_Advanced_Contest_3;

import java.util.HashMap;
import java.util.Map;

/*
you're given an array A(CAN CONTAIN DUPLICATE ELEMENTS) and an integer B, In 1 operation, you can pick2 numbers from the array whose sum equals B
and remove them from the array, Return the maximum no of operations you can perform on the array
 */
public class MaximumOperationsRepeated {
    public static int solve(int[] A, int B) {
        // Create a HashMap to store the frequency of each number in the array.
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each number in the array and store it in the map.
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Initialize the operations count to 0.
        int operations = 0;

        // Iterate through the original array A.
        for (int num : A) {
            // Calculate the complement of the current number.
            int complement = B - num;

            // Check if the complement exists in the frequencyMap and has a positive count.
            if (frequencyMap.containsKey(complement) && frequencyMap.get(complement) > 0) {
                // If a pair is found, increment the operations count.
                operations++;

                // Decrement the frequency of both numbers in the map.
                frequencyMap.put(num, frequencyMap.get(num) - 1);
                frequencyMap.put(complement, frequencyMap.get(complement) - 1);
            }
        }

        // Return the maximum number of operations that can be performed.
        return operations;
    }

    public static void main(String[] args) {
        // Example usage
        int[] array = {2, 5, 3, 4, 2, 5, 3, 4};
        int targetSum = 7;
        int maxOperations = solve(array, targetSum);
        System.out.println("Maximum operations: " + maxOperations);
    }
}
