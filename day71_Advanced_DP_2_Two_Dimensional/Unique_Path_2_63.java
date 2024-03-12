package day71_Advanced_DP_2_Two_Dimensional;

import java.util.Arrays;

/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */

/**
 * Time Complexity: O(M*N)
 * - Reason: At max, there will be M*N calls of recursion.
 * <p>
 * Space Complexity: O((N-1)+(M-1)) + O(M*N)
 * - Reason: We are using a recursion stack space: O((N-1)+(M-1)), here (N-1)+(M-1) is the path length,
 * and an external DP Array of size 'M*N'.
 */
class Unique_Path_2_63 {

    // Helper function to calculate the number of paths through the maze
    static int mazeObstaclesUtil(int i, int j, int[][] maze, int[][] dp) {
        // If there's an obstacle at this cell or out of bounds, return 0
        if (i >= 0 && j >= 0 && maze[i][j] == 1)
            return 0;

        // If we've reached the start cell, there's one valid path
        if (i == 0 && j == 0)
            return 1;

        // If we're out of bounds, return 0
        if (i < 0 || j < 0)
            return 0;

        // If we've already calculated this cell, return the stored result
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of paths by moving up and left
        int up = mazeObstaclesUtil(i - 1, j, maze, dp);
        int left = mazeObstaclesUtil(i, j - 1, maze, dp);

        // Store the result and return it
        return dp[i][j] = up + left;
    }

    // Main function to calculate the number of paths through the maze
    static int uniquePathsWithObstacles(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        int dp[][] = new int[n][m];

        // Initialize the dp array with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the helper function starting from the bottom-right cell
        return mazeObstaclesUtil(n - 1, m - 1, maze, dp);
    }
}
