package day76_Advanced_Graphs_1_DFS_BFS;
/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */

/*
Time Complexity: O(n * m * 4)
Reason: Worst-case – We will be making each fresh orange rotten in the grid, and for each rotten orange, we will check in 4 directions.
Space Complexity: O(n * m)
Reason: Worst-case – If all oranges are rotten, we will end up pushing all rotten oranges into the Queue data structure.
*/

import java.util.LinkedList;
import java.util.Queue;

class RottenOranges_994 {
    // Function to find the minimum minutes until no fresh orange is left
    public int orangesRotting(int[][] grid) {
        // Queue to store the position of rotten oranges
        Queue<Pairs> q = new LinkedList<>();

        // Counters for fresh oranges before and after the process
        int fresh = 0, afterFresh = 0;

        // Get the dimensions of the grid
        int n = grid.length, m = grid[0].length;

        // Array to mark visited positions
        int[][] v = new int[n][m];

        // Arrays to define the four possible directions
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        // Variable to track result
        int res = 0;

        // Loop through the grid to initialize the queue and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    // If the cell contains a rotten orange, add it to the queue
                    q.offer(new Pairs(i, j, 0));
                    // Mark it as visited
                    v[i][j] = 2;
                }
                if (grid[i][j] == 1)
                    // Count the number of fresh oranges
                    fresh++;
            }
        }

        // Perform BFS until the queue is empty
        while (!q.isEmpty()) {
            Pairs curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int t = curr.time;

            // Update the result to the maximum time encountered so far
            res = Math.max(res, t);

            // Check the four directions for fresh oranges and add them to the queue
            for (int i = 0; i < 4; i++) {
                int r = row + dRow[i];
                int c = col + dCol[i];

                // Check if the position is within bounds and contains a fresh orange
                if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1 && v[r][c] == 0) {
                    // Add the fresh orange to the queue with updated time
                    q.offer(new Pairs(r, c, t + 1));
                    // Mark the cell as visited
                    v[r][c] = 2;
                    // Increment the count of fresh oranges after they become rotten
                    afterFresh++;
                }
            }
        }

        // If the number of fresh oranges before and after the process is not equal, return -1 (impossible)
        if (fresh != afterFresh)
            return -1;

        // Return the maximum time encountered during the process
        return res;
    }
}

// Class representing a pair of coordinates and time
class Pairs {
    int row;
    int col;
    int time;

    // Constructor for Pair class
    public Pairs(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
