package day76_Advanced_Graphs_1_DFS_BFS;
/*
Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of
connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only
if one island is not equal to another (not rotated or reflected).

Example 1:

Input:
grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}}
Output:
1
Explanation:
grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}}
Same colored islands are equal.
We have 2 equal islands, so we
have only 1 distinct island.

Example 2:

Input:
grid[][] = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}}
Output:
3
Explanation:
grid[][] = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}}
Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.
 */
//Time Complexity: O(n * m)
//Space Complexity: O(n * m)

import java.util.ArrayList;
import java.util.HashSet;

class NumberOfDistinctIslands_Leetcode_Premium {
    // DFS function to traverse the connected island cells and record their relative positions
    public void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> arr, int row0, int col0) {
        int n = grid.length;
        int m = grid[0].length;

        // Mark the current cell as visited
        vis[row][col] = 1;

        // Record the relative position of the current cell with respect to the starting cell
        arr.add(toString(row - row0, col - col0));

        // Possible moves: up, left, down, right
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};

        // Explore neighbors
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // Check if the neighbor is within bounds, unvisited, and part of the island
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, arr, row0, col0);
            }
        }
    }

    // Utility function to convert coordinates to string
    public String toString(int a, int b) {
        return Integer.toString(a) + " " + Integer.toString(b);
    }

    // Main function to count distinct islands
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Array to track visited cells
        int[][] vis = new int[n][m];

        // Set to store distinct islands represented by relative cell positions
        HashSet<ArrayList<String>> set = new HashSet<>();

        // Iterate through the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Check if the cell is unvisited and part of an island
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    // Initialize array to store relative positions for the current island
                    ArrayList<String> arr = new ArrayList<>();

                    // DFS to traverse the island and record relative positions
                    dfs(i, j, vis, grid, arr, i, j);

                    // Add the recorded relative positions to the set
                    set.add(arr);
                }
            }
        }

        // Return the count of distinct islands
        return set.size();
    }
}
