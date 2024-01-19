package day78_Advanced_Graphs_3_MST_Dijkstra;

import java.util.LinkedList;
import java.util.Queue;

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
/*
Time Complexity: O( 8*N*M ) { N*M are the total cells, for each of which we also check 8 adjacent nodes for the shortest path length},
Where N = No. of rows of the binary maze and M = No. of columns of the binary maze.

Space Complexity: O( N*M ), Where N = No. of rows of the binary maze and M = No. of columns of the binary maze.
*/

class Tuple {
    int distance, row, col;

    Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

public class ShortestPathInABinaryMatrix_1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        if (grid[0][0] == 1 || grid[numRows - 1][numCols - 1] == 1) {
            return -1;
        }

        int[][] distances = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        distances[0][0] = 1;

        Queue<Tuples> queue = new LinkedList<>();
        queue.add(new Tuples(1, 0, 0));

        int[] deltaRows = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] deltaCols = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!queue.isEmpty()) {
            Tuples current = queue.poll();
            int currentDistance = current.distance;
            int row = current.row;
            int col = current.col;

            for (int i = 0; i < 8; i++) {
                int newRow = row + deltaRows[i];
                int newCol = col + deltaCols[i];

                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols
                        && grid[newRow][newCol] == 0 && currentDistance + 1 < distances[newRow][newCol]) {
                    distances[newRow][newCol] = 1 + currentDistance;

                    if (newRow == numRows - 1 && newCol == numCols - 1) {
                        return distances[newRow][newCol];
                    }

                    queue.add(new Tuples(1 + currentDistance, newRow, newCol));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Example usage of the shortestPathBinaryMatrix method
        int[][] grid = {
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };

        ShortestPathInABinaryMatrix_1091 solution = new ShortestPathInABinaryMatrix_1091();
        int shortestPathLength = solution.shortestPathBinaryMatrix(grid);

        System.out.println("Shortest Path Length: " + shortestPathLength);
    }
}
