package day71_Advanced_DP_2_Two_Dimensional;

import java.util.Arrays;
/*
Given an array arr, partition it into two subsets(possibly empty) such that their union is the original array. Let the sum of
the element of these two subsets be S1 and S2.

Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference S1 and S2
is equal to d. since the answer may be large return it modulo 109 + 7.
 */

/*
 * Time Complexity: O(N*K) + O(N)
 * Reason: There are N*K states, so at max ‘N*K’ new problems will be solved.
 *         We are running a for loop for ‘N’ times to calculate the total sum.
 *
 * Space Complexity: O(N*K) + O(N)
 * Reason: We are using recursion stack space (O(N)) and a 2D array (O(N*K)) for memoization.
 */

public class SubsetPartitionWithGivenDifferenceCounter {

    // Modulo value for handling large numbers
    static int mod = (int) (Math.pow(10, 9) + 7);

    public static int countPartitions(int n, int d, int[] arr) {
        // Calculate the total sum of the array elements
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

/*
   Given equation:
       question,
               s1 - s2 = D

   Deduction steps:
       1. Define totalSum as the sum of s1 and s2:
               s1 + s2 = totalSum

       2. Express s1 in terms of totalSum and s2:
               s1 = totalSum - s2

       3. Substitute s1 back into the original question:
               (totalSum - s2) - s2 = D

       4. Simplify the equation:
               totalSum - D = 2 * s2

       5. Solve for s2:
               s2 = (totalSum - D) / 2
*/

        /*
        Edge Cases:

The following edge cases need to be handled:

As the array elements are positive integers including zero, we don’t want to find the case when S2 is
negative or we can say that totSum is lesser than D, therefore if totSum<D, we simply return 0.
S2 can’t be a fraction, as all elements are integers, therefore if totSum – D is odd, we can return 0.

         */

        // Checking for edge cases
        // Ensure that the totalSum minus the target difference is non-negative
        if (totalSum - d < 0) return 0;

        // Ensure that the totalSum minus the target difference is even
        if ((totalSum - d) % 2 == 1) return 0;

        // Calculate the target sum for subsets
        int targetSum = (totalSum - d) / 2;

        // Create a memoization table to store already computed results
        int[][] memo = new int[n + 1][targetSum + 1];

        // Initialize the memo table with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function with memoization
        return countSubsetsWithSumRecursive(arr, n, targetSum, memo);
    }

    private static int countSubsetsWithSumRecursive(int[] arr, int n, int targetSum, int[][] memo) {

        // Base case: No elements remaining to consider (n is 0)
        if (n == 0) {
            // If the target sum is 0, there is one valid subset
            // Otherwise, there is no valid subset
            if (targetSum == 0) {
                return 1; // One valid subset
            }
            return 0; // No valid subset
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
        // Memoize the resul
        return memo[n][targetSum] = (withoutCurrent + withCurrent) % mod;
    }
}
