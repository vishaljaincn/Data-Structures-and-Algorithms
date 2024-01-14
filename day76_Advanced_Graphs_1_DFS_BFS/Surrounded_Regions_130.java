package day76_Advanced_Graphs_1_DFS_BFS;
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
/*
Time Complexity: O(N) + O(M) + O(NxMx4) ~ O(N x M), For the worst case, every element will be marked as ‘O’ in the matrix, and the DFS function will be called for (N x M) nodes and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time. Also, we are running loops for boundary elements so it will take O(N) + O(M).

Space Complexity ~ O(N x M), O(N x M) for the visited array, and auxiliary stack space takes up N x M locations at max.
*/

class Surrounded_Regions_130 {
    // Depth-First Search (DFS) function to traverse and mark connected 'O' cells as visited
    static void dfs(int row, int col, int vis[][], char mat[][], int delrow[], int delcol[]) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;

        // Check for top, right, bottom, left neighbors
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // Check for valid coordinates and unvisited 'O' cells
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    }

    // Function to solve the problem and convert surrounded 'O' cells to 'X'
    static void solve(char mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int delrow[] = {-1, 0, +1, 0};  // Changes in row for top, right, bottom, left neighbors
        int delcol[] = {0, 1, 0, -1};  // Changes in column for top, right, bottom, left neighbors
        int vis[][] = new int[n][m];   // Visited array to keep track of visited cells

        // Traverse first row and last row
        for (int j = 0; j < m; j++) {
            // Check for unvisited 'O' cells in the boundary rows (first and last)
            if (vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delrow, delcol);
            }

            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, delrow, delcol);
            }
        }

        // Traverse first column and last column
        for (int i = 0; i < n; i++) {
            // Check for unvisited 'O' cells in the boundary columns (first and last)
            if (vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delrow, delcol);
            }

            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, delrow, delcol);
            }
        }

        // Convert unvisited 'O' cells to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O')
                    mat[i][j] = 'X';
            }
        }
    }
}
