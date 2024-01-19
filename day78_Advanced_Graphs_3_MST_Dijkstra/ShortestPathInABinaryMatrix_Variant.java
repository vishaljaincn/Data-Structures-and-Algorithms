package day78_Advanced_Graphs_3_MST_Dijkstra;
/*
Given an n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a
given source cell to a destination cell. The path can only be created out of a cell if its value is 0.
If the path is not possible between the source cell and the destination cell, then return -1.
Note: You can move into an adjacent cell if that adjacent cell is filled with element 0, you can move in one of four
directions, Up, Down, Left, and Right.
 */
/*
Time Complexity: O( 4*N*M ) { N*M are the total cells, for each of which we also check 4 adjacent nodes for the
shortest path length}, Where N = No. of rows of the binary maze and M = No. of columns of the binary maze.

Space Complexity: O( N*M ), Where N = No. of rows of the binary maze and M = No. of columns of the binary maze.
 */

import java.util.LinkedList;
import java.util.Queue;

class Tuples {
    int distance, row, col;

    Tuples(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

public class ShortestPathInABinaryMatrix_Variant {

    // Function to find the shortest path in a maze
    public static int mazeRunner(int n, int m, int[][] A, int[] B, int[] C) {
        int numRows = A.length;
        int numCols = A[0].length;

        if (A[B[0]][B[1]] == 1 || A[C[0]][C[1]] == 1) {
            return -1; // Starting or destination position is a wall, impossible to reach.
        }

        int[][] distances = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        distances[B[0]][B[1]] = 0;

        Queue<Tuples> queue = new LinkedList<>();
        queue.add(new Tuples(0, B[0], B[1]));

        int[] deltaRows = {-1, 0, 1, 0};
        int[] deltaCols = {0, -1, 0, 1};

        while (!queue.isEmpty()) {
            Tuples current = queue.poll();
            int row = current.row;
            int col = current.col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + deltaRows[i];
                int newCol = col + deltaCols[i];

                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols
                        && A[newRow][newCol] == 0 && current.distance + 1 < distances[newRow][newCol]) {
                    distances[newRow][newCol] = 1 + current.distance;

                    if (newRow == C[0] && newCol == C[1]) {
                        return distances[newRow][newCol];
                    }

                    queue.add(new Tuples(distances[newRow][newCol], newRow, newCol));
                }
            }
        }

        return -1; // Destination is not reachable.
    }

    public static void main(String[] args) {
        // Example usage of mazeRunner function

        // Create a sample maze (0 represents a path, 1 represents a wall)
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        // Define starting and destination positions
        int[] start = {0, 0}; // Example: Top-left corner
        int[] destination = {4, 4}; // Example: Bottom-right corner

        // Call the mazeRunner function
        int result = mazeRunner(maze.length, maze[0].length, maze, start, destination);

        // Display the result
        if (result != -1) {
            System.out.println("Shortest path length: " + result);
        } else {
            System.out.println("Destination is not reachable.");
        }
    }
}
