package day71_Advanced_DP_2_Two_Dimensional;

import java.util.Arrays;

/**
 * Time Complexity: O(M*N)
 * - Reason: At max, there will be M*N calls of recursion.
 * <p>
 * Space Complexity: O((N-1)+(M-1)) + O(M*N)
 * - Reason: We are using a recursion stack space: O((N-1)+(M-1)), here (N-1)+(M-1) is the path length,
 * and an external DP Array of size 'M*N'.
 */
class UniquePath_1_62 {
    // Function to count the number of ways to reach cell (i, j)
    static int countWaysUtil(int i, int j, int[][] dp) {
        // If we reach the starting cell (0, 0), there's one way to reach it.
        if (i == 0 && j == 0)
            return 1;

        // If we go out of bounds, there's no way to reach the cell.
        if (i < 0 || j < 0)
            return 0;

        // If the value for this cell is already computed, return it.
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of ways by moving up and moving left.
        int up = countWaysUtil(i - 1, j, dp);
        int left = countWaysUtil(i, j - 1, dp);

        // Store the result in the DP array and return it.
        return dp[i][j] = up + left; // Memoization: store the computed result to avoid redundant calculations
    }

    // Function to count the number of ways to reach cell (m-1, n-1)
    static int uniquePath(int m, int n) {
        // Create a 2D DP array to store the results
        int dp[][] = new int[m][n];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Start the recursive calculation from the bottom-right cell (m-1, n-1)
        return countWaysUtil(m - 1, n - 1, dp);
    }
}
