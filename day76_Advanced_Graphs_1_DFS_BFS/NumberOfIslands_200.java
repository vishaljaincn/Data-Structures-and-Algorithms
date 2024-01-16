package day76_Advanced_Graphs_1_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */
/*
Time complexity:
O(n^2).
Space complexity:
O(n^2) visit grid
*/
// Class to represent a pair of coordinates (row, column)
class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class NumberOfIslands_200 {

    // Main function to count the number of islands
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols]; // Array to track visited cells
        int islandsCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // If the cell is unvisited land, start BFS to explore the island
                if (grid[row][col] == '1' && visited[row][col] == 0) {
                    islandsCount++;
                    bfs(row, col, visited, grid);
                }
            }
        }

        return islandsCount;
    }

    // BFS function to explore the island starting from a given cell
    private void bfs(int startRow, int startCol, int[][] visited, char[][] grid) {
        int[] dr = {-1, 0, 1, 0}; // Offsets to move in four directions (up, right, down, left)
        int[] dc = {0, 1, 0, -1};

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startRow, startCol));
        visited[startRow][startCol] = 1; // Mark the starting cell as visited

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            // Explore neighbors in all four directions
            for (int i = 0; i < 4; i++) {
                int newRow = current.row + dr[i];
                int newCol = current.col + dc[i];

                // Check if the neighbor is within the grid boundaries and is unvisited land
                if (isValid(newRow, newCol, grid.length, grid[0].length)
                        && grid[newRow][newCol] == '1' && visited[newRow][newCol] == 0) {
                    queue.offer(new Pair(newRow, newCol));
                    visited[newRow][newCol] = 1; // Mark the neighbor as visited
                }
            }
        }
    }

    // Helper function to check if coordinates are within grid boundaries
    private boolean isValid(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}
