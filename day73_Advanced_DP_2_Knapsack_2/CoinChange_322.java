package day73_Advanced_DP_2_Knapsack_2;

import java.util.Arrays;
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 */
/**
 * Time Complexity: O(n * amount), where n is the number of coins and amount is the target amount.
 * - The function has n * amount subproblems, and each subproblem takes constant time.
 * <p>
 * Space Complexity: O(n * amount), for the memoization table.
 * - Additional space is used to store intermediate results in the memoization table.
 */
public class CoinChange_322 {

    // Memoization table to store computed results
    private int[][] dp;

    // Main function to find the minimum number of coins needed
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // Initialize the memoization table with -1
        dp = new int[n + 1][amount + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Call the helper function to solve the problem
        int ans = solve(coins, n, amount);

        // If the result is the maximum possible value, return -1 (indicating no valid solution)
        return (ans == (int) Math.pow(10, 9)) ? -1 : ans;
    }

    // Helper function for recursive dynamic programming
    private int solve(int[] coins, int n, int amt) {
        // Base case: If there are no more coins available or the remaining amount is negative,
        // return a large value, indicating no valid solution from this subproblem.
        if (n == 0 || amt < 0)
            return (int) Math.pow(10, 9);

        // Base case: If the remaining amount is non-positive, no more coins needed, return 0.
        if (amt == 0)
            return 0;

        // If the result for the current state is already computed, return it
        if (dp[n][amt] != -1) {
            return dp[n][amt];
        }

        // If the current coin can be used to make change for the remaining amount
        if (coins[n - 1] <= amt) {
            // Choose the minimum between taking the current coin or not taking it
            dp[n][amt] = Math.min(1 + solve(coins, n, amt - coins[n - 1]), solve(coins, n - 1, amt));
        } else {
            // If the current coin's value is greater than the remaining amount, skip it
            dp[n][amt] = solve(coins, n - 1, amt);
        }

        // Return the computed result for the current state
        return dp[n][amt];
    }
}
