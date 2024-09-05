package day78_Advanced_Graphs_3_MST_Dijkstra;
/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where
heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you
hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right,
and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1:
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2:
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than
route [1,3,5,3,5].

Example 3:
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 */
/*
Time Complexity: O( 4*N*M * log( N*M) ) { N*M are the total cells, for each of which we also check 4 adjacent nodes for
the minimum effort and additional log(N*M) for insertion-deletion operations in a priority queue }

Where, N = No. of rows of the binary maze and M = No. of columns of the binary maze.

Space Complexity: O( N*M ) { Distance matrix containing N*M cells + priority queue in the worst case containing all the
nodes ( N*M) }.

Where, N = No. of rows of the binary maze and M = No. of columns of the binary maze.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

// Define a Tuplee class to represent triplets (row, column, effort)
class Tuplee {
    int row;
    int col;
    int effort;

    public Tuplee(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }

}

public class PathWithMinimumEffort_1631 {

    // Main method for testing
    public static void main(String[] args) {
        PathWithMinimumEffort_1631 solution = new PathWithMinimumEffort_1631();
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int result = solution.minimumEffortPath(heights);
        System.out.println(result); // Output: 2
    }

    // Main function to find the minimum effort path
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Array to store minimum efforts to reach each cell
        int[][] efforts = new int[rows][cols];
        for (int[] row : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;

        // Priority queue to store cells with minimum efforts
        PriorityQueue<Tuplee> pq = new PriorityQueue<>((x, y) -> x.effort - y.effort);
        pq.offer(new Tuplee(0, 0, 0)); // Start from the top-left cell

        // Delta arrays representing possible movements (up, right, down, left)
        int[] dr = {-1, 0, 1, 0}; // delta rows
        int[] dc = {0, 1, 0, -1}; // delta columns

        // Dijkstra's algorithm to find the minimum effort path
        while (!pq.isEmpty()) {
            Tuplee curr = pq.poll(); // Extract the cell with the minimum effort
            int row = curr.row;
            int col = curr.col;
            int effort = curr.effort;

            // If we reach the bottom-right cell, return the minimum effort
            if (row == rows - 1 && col == cols - 1) {
                return effort;
            }

            // Iterate through all possible directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                // Check if the new cell is within the grid boundaries
                if (isValid(newRow, newCol, rows, cols)) {
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[newRow][newCol]));

                    // If the new effort is less than the stored effort for the cell, update and enqueue
                    if (newEffort < efforts[newRow][newCol]) {
                        efforts[newRow][newCol] = newEffort;
                        pq.offer(new Tuplee(newRow, newCol, newEffort));
                    }
                }
            }
        }

        // Should not reach here if a valid path exists
        return -1;
    }

    // Helper function to check if a cell is within the grid boundaries
    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
