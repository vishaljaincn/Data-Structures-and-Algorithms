package day71_Advanced_DP_2_Two_Dimensional;

import java.util.Arrays;

/*
 * Time Complexity: O(N*K) + O(N)
 * Reason: There are N*K states, so at max ‘N*K’ new problems will be solved.
 *         We are running a for loop for ‘N’ times to calculate the total sum.
 *
 * Space Complexity: O(N*K) + O(N)
 * Reason: We are using recursion stack space (O(N)) and a 2D array (O(N*K)) for memoization.
 */
public class PartitionEqualSubsetSum_416 {

    // Main function to check if the array can be partitioned into two subsets with equal sum
    public static boolean canPartition(int[] nums) {
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Check if the total sum is odd, it can't be divided into two equal subsets
        if (totalSum % 2 == 1) {
            return false;
        }

        // Calculate the target sum for each subset
        int targetSum = totalSum / 2;

        // Create a memoization table to store already computed results
        boolean[][] memo = new boolean[nums.length + 1][targetSum + 1];

        // Initialize the memo table with false
        for (boolean[] row : memo) {
            Arrays.fill(row, false);
        }

        // Call the recursive function with memoization
        return canPartitionRecursive(nums, nums.length, targetSum, memo);
    }

    // Helper function for recursive approach with memoization
    private static boolean canPartitionRecursive(int[] nums, int n, int targetSum, boolean[][] memo) {
        // Base cases

        // If the target sum is 0, there is always an empty subset
        if (targetSum == 0) {
            return true; // Empty subset
        }

        // If there are no elements left and the target sum is non-zero, no subset is possible
        if (n == 0 || targetSum < 0) {
            return false; // No elements left or the sum is negative
        }

        // Check if the result is already memoized
        if (memo[n][targetSum]) {
            return true;
        }

        // Recursive cases

        // Exclude the current element and consider subsets without it
        boolean withoutCurrent = canPartitionRecursive(nums, n - 1, targetSum, memo);

        // Include the current element only if its value is less than or equal to the target sum
        boolean withCurrent = false;
        if (nums[n - 1] <= targetSum) {
            withCurrent = canPartitionRecursive(nums, n - 1, targetSum - nums[n - 1], memo);
        }

        // Check if either case leads to a subset with the given sum
        return memo[n][targetSum] = withoutCurrent || withCurrent;
    }
}
