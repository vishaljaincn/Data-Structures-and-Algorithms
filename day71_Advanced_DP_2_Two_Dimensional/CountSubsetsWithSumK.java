package day71_Advanced_DP_2_Two_Dimensional;

import java.util.Arrays;
/*
You are given an array of integers arr and an integer K. Your task is to find and count the number of subsets of
the given array whose elements add up to the specified sum K.
 */

/**
 * The time and space complexities of the provided solution are as follows:
 * <p>
 * Time Complexity: O(N * K)
 * <p>
 * The time complexity of the recursive solution with memoization is O(N * K),
 * where N is the number of elements in the array and K is the target sum.
 * This is because, in the worst case, every combination of array elements
 * and possible sums needs to be computed once and stored in the memoization table.
 * <p>
 * Space Complexity: O(N * K)
 * <p>
 * The space complexity is also O(N * K) due to the memoization table.
 * The table has dimensions (N + 1) x (K + 1), where each cell stores an integer value.
 * Therefore, the space required is proportional to the product of N and K.
 */

public class CountSubsetsWithSumK {

    // Function to count the number of subsets with a given sum
    public static int countSubsetsWithSum(int[] arr, int K) {
        // Get the length of the array
        int n = arr.length;

        // Create a memoization table to store already computed results
        int[][] memo = new int[n + 1][K + 1];

        // Initialize the memo table with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function with memoization
        return countSubsetsWithSumRecursive(arr, n, K, memo);
    }

    // Recursive helper function with memoization
    private static int countSubsetsWithSumRecursive(int[] arr, int n, int K, int[][] memo) {
        // Base cases

        // If the required sum is 0, there is always an empty subset
        if (K == 0) {
            return 1; // Empty subset
        }

        // If there are no elements left and the required sum is non-zero, no subset possible
        if (n == 0 || K < 0) {
            return 0; // No elements left or the sum is negative
        }

        // Check if the result is already memoized
        if (memo[n][K] != -1) {
            return memo[n][K];
        }

        // Recursive cases

        // Exclude the current element and consider subsets without it
        int withoutCurrent = countSubsetsWithSumRecursive(arr, n - 1, K, memo);

        // Include the current element only if its value is less than or equal to the required sum
        int withCurrent = 0;
        if (arr[n - 1] <= K) {
            withCurrent = countSubsetsWithSumRecursive(arr, n - 1, K - arr[n - 1], memo);
        }

        // Total number of subsets with the given sum
        // Memoize the result
        return memo[n][K] = withoutCurrent + withCurrent;

    }

    // Main method to test the functionality
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int K = 10;

        // Call the function and print the result
        int result = countSubsetsWithSum(arr, K);
        System.out.println("Number of subsets with sum " + K + ": " + result);
    }
}
