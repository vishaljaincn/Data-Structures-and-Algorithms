package day71_Advanced_DP_2_Two_Dimensional;

/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either
directly below or diagonally left/right. Specifically, the next element from position (row, col) will be
(row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */

// Time Complexity: O(N*M) - There are two nested loops
// Space Complexity: O(N*M) - We are using an external array of size ‘N*M’. The stack space will be eliminated.
class MinimumFallingPathSum_931_Variable_Starting_and_Ending_Points_Using_Tabulation_NO_TLE_Not_Revised {
    static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Dynamic programming table to store the minimum falling sum for each cell
        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the minimum falling sum for each cell in the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Calculate the minimum falling sum for the current cell considering three possible paths

                // Path coming from above
                int up = matrix[i][j] + dp[i - 1][j];

                // Path coming from the left diagonal
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    // If left diagonal is out of bounds, set a large value to simulate its absence
                    leftDiagonal += (int) Math.pow(10, 9);
                }

                // Path coming from the right diagonal
                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    // If right diagonal is out of bounds, set a large value to simulate its absence
                    rightDiagonal += (int) Math.pow(10, 9);
                }

                // Store the minimum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Find the minimum value in the last row of dp
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        return mini;
    }
}
