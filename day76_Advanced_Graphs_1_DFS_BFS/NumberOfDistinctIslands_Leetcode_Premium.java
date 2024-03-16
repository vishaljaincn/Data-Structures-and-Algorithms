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

// Time complexity: O(n * m), where n is the number of rows and m is the number of columns in the grid.
//                   This is because we traverse each cell of the grid once during BFS.
// Space complexity: O(n * m) for the visited array and O(k) for the set, where k is the number of distinct islands.
//                   In the worst case, all cells might be part of the same island, leading to O(n * m) space for the set.

import java.util.*;

public class NumberOfDistinctIslands_Leetcode_Premium {

    // Utility function to convert coordinates to string
    public String toString(int a, int b) {
        return Integer.toString(a) + " " + Integer.toString(b);
    }

    // BFS function to traverse the connected island cells and record their relative positions
    public ArrayList<String> bfs(int row, int col, int[][] vis, int[][] grid, int row0, int col0) {
        int n = grid.length;
        int m = grid[0].length;

        // Queue for BFS traversal
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        vis[row][col] = 1; // Mark the current cell as visited

        ArrayList<String> arr = new ArrayList<>(); // Arraylist to store relative positions

        // Possible moves: up, left, down, right
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int r = current.first;
            int c = current.second;

            // Record the relative position of the current cell with respect to the starting cell
            arr.add(toString(r - row0, c - col0));

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                // Check if the neighbor is within bounds, unvisited, and part of the island
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    queue.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1; // Mark neighbor as visited
                }
            }
        }

        return arr;
    }

    // Main function to count distinct islands
    public int countDistinctIslands(int[][] grid) {
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
                    // BFS to traverse the island and record relative positions
                    ArrayList<String> arr = bfs(i, j, vis, grid, i, j);

                    // Add the recorded relative positions to the set
                    set.add(arr);
                }
            }
        }

        // Return the count of distinct islands
        return set.size();
    }

    // Pair class to represent coordinates
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
