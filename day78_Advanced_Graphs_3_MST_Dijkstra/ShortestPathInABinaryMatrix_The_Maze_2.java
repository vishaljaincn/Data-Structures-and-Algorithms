package day78_Advanced_Graphs_3_MST_Dijkstra;
/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up,down,left or
right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the
destination. The distance is defined by the number of empty spacestraveled by the ball from the start position
(excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the
borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1:
Input 1: a maze represented by a 2D array
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)
Output: 12
Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

Example 2:
Input 1: a maze represented by a 2D array
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)
Output: -1
Explanation: There is no way for the ball to stop at the destination.
 */
/*
Time Complexity: O( E log(V) ), Where E = Number of edges and V = Number of Nodes.

Space Complexity: O( |E| + |V| ), Where E = Number of edges and V = Number of Nodes.
*/

import java.util.PriorityQueue;

// Class representing a tuple with distance, row, and column
class Tuplez implements Comparable<Tuplez> {
    int distance, row, col;

    Tuplez(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(Tuplez other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class ShortestPathInABinaryMatrix_The_Maze_2 {

    // Function to find the shortest distance in a maze using Dijkstra's algorithm
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int numRows = maze.length;
        int numCols = maze[0].length;

        // Priority queue to maintain the order of tuples based on distance
        PriorityQueue<Tuplez> pq = new PriorityQueue<>();

        // Array to store distances from the start position to each cell in the maze
        int[][] distances = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                distances[i][j] = Integer.MAX_VALUE; // Initialize distances to infinity
            }
        }

        distances[start[0]][start[1]] = 0; // Distance to start position is 0
        pq.add(new Tuplez(0, start[0], start[1])); // Add the start position to the priority queue

        // Arrays to represent the possible moves in four directions (up, left, down, right)
        int[] deltaRows = {-1, 0, 1, 0};
        int[] deltaCols = {0, -1, 0, 1};

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Tuplez current = pq.poll(); // Retrieve the tuple with the smallest distance
            int row = current.row;
            int col = current.col;
            int currentDistance = current.distance;

            // Explore possible moves in four directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + deltaRows[i];
                int newCol = col + deltaCols[i];
                int steps = 0;

                // Move in the current direction until a wall or the maze boundary is encountered
                while (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && maze[newRow][newCol] == 0) {
                    newRow += deltaRows[i];
                    newCol += deltaCols[i];
                    steps++;
                }

                // Move back to the last valid position
                newRow -= deltaRows[i];
                newCol -= deltaCols[i];

                // Update the distance if the new path is shorter
                if (currentDistance + steps < distances[newRow][newCol]) {
                    distances[newRow][newCol] = currentDistance + steps;

                    // Check if the destination is reached
                    if (newRow == destination[0] && newCol == destination[1]) {
                        return distances[newRow][newCol];
                    }

                    // Add the new position to the priority queue
                    pq.add(new Tuplez(distances[newRow][newCol], newRow, newCol));
                }
            }
        }

        return -1; // Destination is not reachable.
    }

    // Main method for testing the shortestDistance function
    public static void main(String[] args) {
        // Example usage of shortestDistance function

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

        // Call the shortestDistance function
        int result = shortestDistance(maze, start, destination);

        // Display the result
        if (result != -1) {
            System.out.println("Shortest path length: " + result);
        } else {
            System.out.println("Destination is not reachable.");
        }
    }
}
