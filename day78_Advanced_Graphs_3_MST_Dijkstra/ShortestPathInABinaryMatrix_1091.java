package day78_Advanced_Graphs_3_MST_Dijkstra;

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear
path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell
(i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 */

import java.util.LinkedList;
import java.util.Queue;

/*
Time Complexity: O( 8*N*M ) { N*M are the total cells, for each of which we also check 8 adjacent nodes for the shortest path length},
Where N = No. of rows of the binary maze and M = No. of columns of the binary maze.

Space Complexity: O( N*M ), Where N = No. of rows of the binary maze and M = No. of columns of the binary maze.
*/
class Tuple {
    // Class representing a tuple with distance, row, and column information.
    int distance, row, col;

    Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class ShortestPathInABinaryMatrix_1091 {
    // Method to find the shortest path in a binary maze.
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Get the number of rows and columns in the binary maze.
        int numRows = grid.length;
        int numCols = grid[0].length;

        // Check if the starting or ending cell is blocked, making it impossible to reach the destination.
        if (grid[0][0] == 1 || grid[numRows - 1][numCols - 1] == 1) {
            return -1;
        }

        // If the binary maze has only one cell, and it is not blocked, return 1 as the shortest path.
        if (numRows == 1 && numCols == 1) {
            return 1;
        }

        // Initialize an array to store distances, initially set to maximum possible values.
        int[][] distances = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        // Set the distance of the starting cell to 1.
        distances[0][0] = 1;

        // Initialize a queue for BFS traversal.
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(1, 0, 0));

        // Arrays to represent possible movements in rows and columns.
        int[] deltaRows = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] deltaCols = {-1, 0, 1, -1, 1, -1, 0, 1};

        // BFS traversal of the binary maze.
        while (!queue.isEmpty()) {
            // Dequeue the current tuple.
            Tuple current = queue.poll();
            int currentDistance = current.distance;
            int row = current.row;
            int col = current.col;

            // Check if the destination is reached.
            if (row == numRows - 1 && col == numCols - 1) {
                return currentDistance;
            }

            // Check adjacent cells for possible movements.
            for (int i = 0; i < 8; i++) {
                int newRow = row + deltaRows[i];
                int newCol = col + deltaCols[i];

                // Check if the new position is within bounds and unblocked, and the new distance is shorter.
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols
                        && grid[newRow][newCol] == 0 && currentDistance + 1 < distances[newRow][newCol]) {
                    // Update the distance and enqueue the new position.
                    distances[newRow][newCol] = 1 + currentDistance;

                    // Enqueue the new tuple.
                    queue.add(new Tuple(1 + currentDistance, newRow, newCol));
                }
            }
        }

        // If the destination is not reachable, return -1.
        return -1;
    }
}
