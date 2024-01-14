package day76_Advanced_Graphs_1_DFS_BFS;

/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 */
/*
Time Complexity: O(NxM + NxMx4) ~ O(N x M)
For the worst case, the BFS function will be called for (N x M) nodes,
and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time.

Space Complexity: O(N x M) + O(N x M) + O(N x M) ~ O(N x M)
O(N x M) for the visited array, distance matrix, and queue space takes up N x M locations at max.
*/

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int first;
    int second;
    int third;

    Node(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Zero_One_Matrix_542 {
    // Function to update the matrix with the minimum distance from 0 to each cell
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Node> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        // Enqueue all cells with value 0 into the queue and mark them as visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = 1;
                    q.add(new Node(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        // Define changes in row and column for top, right, bottom, and left neighbors
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        // Perform Breadth-First Search (BFS)
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();

            dist[row][col] = steps; // Update the distance for the current cell

            // Traverse all neighbors of the current cell
            for (int i = 0; i < 4; i++) {
                int nrow = delrow[i] + row;
                int ncol = delcol[i] + col;

                // Check for valid coordinates and unvisited cells
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1; // Mark the neighbor as visited
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }

        return dist;
    }
}
