package day68_Advanced_BackTracking_1;
/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N – 1, N – 1).
Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move
are ‘U'(up), ‘D'(down), ‘L’ (left), ‘R’ (right). Value 0 at a cell in the matrix represents that it is blocked and the rat
cannot move to it while value 1 at a cell in the matrix represents that rat can travel through it.

Note: In a path, no cell can be visited more than one time.

Print the answer in lexicographical(sorted) order

Examples:

Example 1:
Input:
N = 4
m[][] = {{1, 0, 0, 0},
        {1, 1, 0, 1},
        {1, 1, 0, 0},
        {0, 1, 1, 1}}
Output: DDRDRR DRDDRR

Explanation:
The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

Example 2
Input: N = 2
       m[][] = {{1, 0},
                {1, 0}}
Output:
 No path exists because the destination cell is blocked.

 */
/*
Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.There are a total of (4^N*M) function calls

Space Complexity:  O(m*n), Maximum Depth of the recursion tree(auxiliary space).
 */

import java.util.ArrayList;

// Class to find a path in a binary matrix
class RatInAMaze_Approach_2 {

    // Recursive function to find a path
    private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move,
                              int vis[][], int di[], int dj[]) {
        if (i == n - 1 && j == n - 1) {
            // If we reach the bottom-right corner, add the current path to the result
            ans.add(move);
            return;
        }

        // Define the possible directions: Down, Left, Right, Up
        String dir = "DLRU";

        // Iterate through all possible directions
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];

            // Check if the next move is within bounds and has not been visited
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
                    vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {

                // Mark the current cell as visited
                vis[i][j] = 1;

                // Recursively explore the path in the next direction
                solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);

                // Backtrack: Mark the current cell as unvisited
                vis[i][j] = 0;
            }
        }
    }

    // Function to find a path in the matrix
    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];

        // Initialize the visibility matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }

        // Define the possible movements: Down, Left, Right, Up
        int di[] = {+1, 0, 0, -1};
        int dj[] = {0, -1, 1, 0};

        ArrayList<String> ans = new ArrayList<>();

        // If the starting point is valid, initiate the recursive path-finding function
        if (m[0][0] == 1) {
            solve(0, 0, m, n, ans, "", vis, di, dj);
        }

        return ans;
    }

    public static void main(String[] args) {

        // Example matrix and its size
        int n = 4;
        int[][] a = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};

        // Find and print the paths
        ArrayList<String> res = findPath(a, n);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}

