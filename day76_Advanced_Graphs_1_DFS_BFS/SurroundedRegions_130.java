package day76_Advanced_Graphs_1_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/*

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 */
// Time Complexity: O(rows * cols) where rows is the number of rows and cols is the number of columns in the board.
//      - In the worst case, we may visit each cell of the board once in the BFS traversal, and for each cell, we explore its four neighbors.
// Space Complexity: O(rows * cols) for the visited array and the queue:
//      - The visited array occupies O(rows * cols) space to mark visited cells to avoid revisiting.
//      - The queue may contain all boundary cells in the worst case, leading to O(rows * cols) space usage.
//      - Overall, the space complexity is dominated by the visited array and the queue.
class SurroundedRegions_130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return; // Return if board is null or empty

        int rows = board.length;
        int cols = board[0].length;

        // Define directions for exploring neighbors
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Marking visited cells to avoid revisiting
        boolean[][] visited = new boolean[rows][cols];

        // Queue for BFS traversal
        Queue<Pair> queue = new LinkedList<>();

        // Add boundary cells to queue and mark them as visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    queue.offer(new Pair(i, j)); // Add boundary cell to queue
                    visited[i][j] = true; // Mark boundary cell as visited
                }
            }
        }

        // BFS traversal starting from boundary cells
        while (!queue.isEmpty()) {
            Pair current = queue.poll(); // Retrieve current cell from queue
            int row = current.first;
            int col = current.second;

            // Mark current cell as 'B' (boundary)
            board[row][col] = 'B';

            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if neighbor is within board boundaries and is unvisited 'O'
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && !visited[newRow][newCol] && board[newRow][newCol] == 'O') {
                    queue.offer(new Pair(newRow, newCol)); // Add neighbor to queue
                    visited[newRow][newCol] = true; // Mark neighbor as visited
                }
            }
        }

        // Flip 'O's to 'X's and 'B's back to 'O's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'B')
                    board[i][j] = 'O';
            }
        }
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
