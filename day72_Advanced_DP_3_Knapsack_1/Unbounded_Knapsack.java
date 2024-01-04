package day72_Advanced_DP_3_Knapsack_1;

import java.util.Arrays;

/*
Problem Statement:
You are given weights and values of N items, put these items in a knapsack of capacity W
to get the maximum total value in the knapsack. Each item can be selected multiple times,
hence the name "Unbounded Knapsack Problem."

Implement the function unboundedKnapSack to find the maximum value that can be put into
the knapsack given the weights and values of items.

Input:
- The integer W representing the maximum capacity of the knapsack.
- Arrays wt[] and val[] representing the weights and values of N items respectively.
- The integer N representing the number of items.

Output:
- An integer representing the maximum value that can be put into the knapsack.

Time Complexity:
- O(W * n), where W is the maximum capacity of the knapsack and n is the number of items.

Space Complexity:
- O(W * n) due to the memoization array.
*/
public class Unbounded_Knapsack {

    // Function to solve the Unbounded Knapsack problem using memoization
    static int unboundedKnapSack(int W, int wt[], int val[], int n) {
        // Create a memoization array to store results of subproblems
        int[][] memo = new int[n + 1][W + 1];

        // Initialize memoization array with -1
        for (int[] row : memo)
            Arrays.fill(row, -1);

        // Call the helper function with initial parameters
        return unboundedKnapSackHelper(W, wt, val, n, memo);
    }

    // Helper function for recursive memoized approach for Unbounded Knapsack
    static int unboundedKnapSackHelper(int W, int wt[], int val[], int n, int[][] memo) {
        // Base case: if no items left or knapsack capacity is 0
        if (n == 0 || W == 0)
            return 0;

        // If result for the current subproblem is already computed, return it
        if (memo[n][W] != -1)
            return memo[n][W];

        // Check if the current item can be included in the knapsack
        if (wt[n - 1] <= W) {
            // Include the current item or exclude it, choose the maximum value
            memo[n][W] = Math.max(val[n - 1] + unboundedKnapSackHelper(W - wt[n - 1], wt, val, n, memo),
                    unboundedKnapSackHelper(W, wt, val, n - 1, memo));
        } else {
            // If the current item's weight is more than the remaining capacity, exclude it
            memo[n][W] = unboundedKnapSackHelper(W, wt, val, n - 1, memo);
        }

        // Return the computed result for the current subproblem
        return memo[n][W];
    }

    // Main function to test the Unbounded Knapsack algorithm
    public static void main(String args[]) {
        int val[] = {5, 11, 13};
        int wt[] = {2, 4, 6};
        int W = 10;
        int n = val.length;

        // Print the maximum value that can be put in the knapsack
        System.out.println("Maximum value in Unbounded Knapsack: " + unboundedKnapSack(W, wt, val, n));
    }
}
