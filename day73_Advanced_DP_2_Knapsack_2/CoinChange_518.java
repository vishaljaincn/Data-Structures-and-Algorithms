package day73_Advanced_DP_2_Knapsack_2;

import java.util.Arrays;

/**
 * Time Complexity: O(n * amount), where n is the number of coins and amount is the target amount.
 * - The function has n * amount subproblems, and each subproblem takes constant time.
 * <p>
 * Space Complexity: O(n * amount), for the memoization table.
 * - Additional space is used to store intermediate results in the memoization table.
 */
public class CoinChange_518 {

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
        // Base case: if the amount is 0, there is one way to make change (no coins)
        if (amount == 0)
            return 1;

        // Base case: if no coins left or amount is negative, there is no way to make change
        if (n == 0 || amount < 0)
            return 0;

        // If result for the current subproblem is already computed, return it
        if (memo[n][amount] != -1)
            return memo[n][amount];

        // Include the current coin or exclude it, choose the sum of both possibilities
        memo[n][amount] = changeHelper(amount - coins[n - 1], coins, n, memo) +
                changeHelper(amount, coins, n - 1, memo);

        // Return the computed result for the current subproblem
        return memo[n][amount];
    }
}
