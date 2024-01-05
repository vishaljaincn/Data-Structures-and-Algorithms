package day71_Advanced_DP_2_Two_Dimensional;

import java.util.Arrays;

/**
 * SubsetPartitionCounter class provides a solution to count the number of partitions with a given difference.
 */
public class SubsetPartitionCounter {

    // Modulo value for handling large numbers
    static int mod = (int) (Math.pow(10, 9) + 7);

    /**
     * Counts the number of partitions with a given difference.
     *
     * @param n   The number of elements in the array.
     * @param d   The target difference for the partition.
     * @param arr The input array containing elements.
     * @return The number of partitions with the specified difference.
     */
    public static int countPartitions(int n, int d, int[] arr) {
        // Calculate the total sum of the array elements
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        // Checking for edge cases
        // Ensure that the totalSum minus the target difference is non-negative
        if (totalSum - d < 0) return 0;

        // Checking for edge cases
        // Ensure that the totalSum plus the target difference is even
        if ((totalSum + d) % 2 == 1) return 0;

        // Calculate the target sum for subsets
        int targetSum = (totalSum + d) / 2;

        // Create a memoization table to store already computed results
        int[][] memo = new int[n + 1][targetSum + 1];

        // Initialize the memo table with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function with memoization
        return countSubsetsWithSumRecursive(arr, n, targetSum, memo);
    }

    /**
     * Recursive helper function to count subsets with a given sum.
     *
     * @param arr       The input array containing elements.
     * @param n         The current index in the array.
     * @param targetSum The target sum for subsets.
     * @param memo      Memoization table to store already computed results.
     * @return The number of subsets with the specified sum.
     */
    private static int countSubsetsWithSumRecursive(int[] arr, int n, int targetSum, int[][] memo) {
        // Base cases

        // If the required sum is 0, there is always an empty subset
        if (targetSum == 0) {
            return 1; // Empty subset is always a valid solution
        }

        // If there are no elements left and the required sum is non-zero, no subset is possible
        if (n == 0 || targetSum < 0) {
            return 0; // No elements left or the sum is negative, no valid subset
        }

        // Check if the result is already memoized
        if (memo[n][targetSum] != -1) {
            return memo[n][targetSum];
        }

        // Recursive cases

        // Exclude the current element and consider subsets without it
        int withoutCurrent = countSubsetsWithSumRecursive(arr, n - 1, targetSum, memo);

        // Include the current element only if its value is less than or equal to the required sum
        int withCurrent = 0;
        if (arr[n - 1] <= targetSum) {
            withCurrent = countSubsetsWithSumRecursive(arr, n - 1, targetSum - arr[n - 1], memo);
        }

        // Total number of subsets with the given sum
        // Memoize the result
        return memo[n][targetSum] = (int) ((withoutCurrent + withCurrent) % mod);
    }
}
