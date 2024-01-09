package day71_Advanced_DP_2_Two_Dimensional;

import java.util.Arrays;
/*
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
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

public class CheckSubsetSumEqualToK {

    // Function to check if there exists a subset with sum equal to K
    public static boolean hasSubsetWithSum(int[] arr, int K) {
        // Get the length of the array
        int n = arr.length;

        // Create a memoization table to store already computed results
        boolean[][] memo = new boolean[n + 1][K + 1];

//        // Initialize the memo table with false
//        for (boolean[] row : memo) {
//            Arrays.fill(row, false);
//        }

        // Call the recursive function with memoization
        return hasSubsetWithSumRecursive(arr, n, K, memo);
    }

    // Recursive helper function with memoization
    private static boolean hasSubsetWithSumRecursive(int[] arr, int n, int K, boolean[][] memo) {

        // Base case: No elements remaining to consider (n is 0)
        if (n == 0) {
            // If the target sum is 0, there is a valid subset
            // Otherwise, there is no valid subset
            if (K == 0) {
                return true; // valid subset
            }
            return false; // No valid subset
        }

        // Check if the result is already memoized
        if (memo[n][K]) {
            return true;
        }

        // Recursive cases

        // Exclude the current element and consider subsets without it
        boolean withoutCurrent = hasSubsetWithSumRecursive(arr, n - 1, K, memo);

        // Include the current element only if its value is less than or equal to the required sum
        boolean withCurrent = false;
        if (arr[n - 1] <= K) {
            withCurrent = hasSubsetWithSumRecursive(arr, n - 1, K - arr[n - 1], memo);
        }

        // Check if either case leads to a subset with the given sum
        return memo[n][K] = withoutCurrent || withCurrent;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int K = 4;

        // Call the function and print the result
        boolean result = hasSubsetWithSum(arr, K);
        System.out.println("Does there exist a subset with sum " + K + "? " + result);
    }
}
