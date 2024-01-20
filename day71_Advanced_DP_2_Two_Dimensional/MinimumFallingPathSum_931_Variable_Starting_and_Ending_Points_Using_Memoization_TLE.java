package day71_Advanced_DP_2_Two_Dimensional;
/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either
directly below or diagonally left/right. Specifically, the next element from position (row, col) will be
(row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
/*
Time Complexity: O(N*N)
Reason: At max, there will be M*N calls of recursion to solve a new problem.

Space Complexity: O(N) + O(N*M)
Reason: We are using a recursion stack space: O(N), where N is the path length, and an external DP Array of size ‘N*M’.
*/

import java.util.Arrays;

class MinimumFallingPathSum_931_Variable_Starting_and_Ending_Points_Using_Memoization_TLE {
    // Function to find the minimum falling path sum using dynamic programming
    static int getMinFallingUtil(int i, int j, int n, int[][] matrix, int[][] dp) {
        // Base Conditions
        if (i < 0 || i >= n || j < 0 || j >= n)
            return (int) Math.pow(10, 9); // Return a very large value for out-of-bounds positions
        if (i == 0)
            return matrix[0][j]; // Base case for the first row

        if (dp[i][j] != -1)
            return dp[i][j]; // Return the precomputed value if already calculated

        // Calculate three possible paths: moving down, left diagonal, and right diagonal
        int down = matrix[i][j] + getMinFallingUtil(i - 1, j, n, matrix, dp);
        int leftDiagonal = matrix[i][j] + getMinFallingUtil(i - 1, j - 1, n, matrix, dp);
        int rightDiagonal = matrix[i][j] + getMinFallingUtil(i - 1, j + 1, n, matrix, dp);

        // Store the minimum of the three paths in dp
        return dp[i][j] = Math.min(down, Math.min(leftDiagonal, rightDiagonal));
    }

    // Function to find the minimum falling path sum in the matrix
    static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1); // Initialize dp array with -1

        int mini = Integer.MAX_VALUE; // Initialize the minimum path sum

        // For each starting column, find the minimum falling path sum and update mini
        for (int j = 0; j < n; j++) {
            int ans = getMinFallingUtil(n - 1, j, n, matrix, dp); // Calculate minimum falling path sum for each starting column
            mini = Math.min(mini, ans); // Update the minimum falling path sum
        }

        return mini; // Return the overall minimum falling path sum
    }
}
