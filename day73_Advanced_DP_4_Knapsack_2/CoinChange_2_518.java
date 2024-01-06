package day73_Advanced_DP_4_Knapsack_2;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing
a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any
combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

 */

/**
 * This class represents a solution to the Coin Change 2 problem using a recursive memoized approach.
 * The goal is to find the number of combinations that make up a given amount using a given set of coins.
 *
 * Time Complexity: O(n * amount), where n is the number of coins and amount is the target amount.
 * - The function has n * amount subproblems, and each subproblem takes constant time.
 *
 * Space Complexity: O(n * amount), for the memoization table.
 * - Additional space is used to store intermediate results in the memoization table.
 */
public class CoinChange_2_518 {

    // Main function to calculate the number of ways to make change for a given amount
    public int change(int amount, int[] coins) {
        // Create a memoization array to store results of subproblems
        int[][] memo = new int[coins.length + 1][amount + 1];

        // Initialize memoization array with -1, indicating subproblems haven't been solved yet
        for (int[] row : memo)
            Arrays.fill(row, -1);

        // Call the helper function with initial parameters
        return changeHelper(amount, coins, coins.length, memo);
    }

    // Helper function for recursive memoized approach for Coin Change 2
    private int changeHelper(int amount, int[] coins, int n, int[][] memo) {
        // Base case: No coins remaining to consider (n is 0)
        if (n == 0) {
            // If the target amount is 0, there is one valid combination (empty subset)
            // Otherwise, there is no valid combination
            if (amount == 0) {
                return 1; // One valid combination (empty subset)
            }
            return 0; // No valid combination
        }

        // If result for the current subproblem is already computed, return it
        if (memo[n][amount] != -1) return memo[n][amount];

        // Calculate the number of combinations without taking the current coin
        int notTaken = changeHelper(amount, coins, n - 1, memo);

        // Calculate the number of combinations by taking the current coin
        int taken = 0;
        if (coins[n - 1] <= amount) {
            taken = changeHelper(amount - coins[n - 1], coins, n, memo);
        }

        // Return the computed result for the current subproblem
        return memo[n][amount] = notTaken + taken;
    }
}
