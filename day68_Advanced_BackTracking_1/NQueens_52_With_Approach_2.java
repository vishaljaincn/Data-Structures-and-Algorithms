package day68_Advanced_BackTracking_1;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
Input: n = 1
Output: 1
*/
/*
Time Complexity: Exponential in nature since we are trying out all ways, to be precise it is O(N! * N).
                 total N! function calls and loop of N size is running for each function call.

Space Complexity: O(N) Maximum Depth of the recursion tree(auxiliary space).
*/

class NQueens_52_With_Approach_2 {
    // Counter to store the count of distinct solutions
    static int count = 0;

    // Function to solve the N-Queens problem and return the number of distinct solutions
    public static int totalNQueens(int n) {
        // Arrays to keep track of the availability of rows and diagonals
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        // Start the recursive solving process
        solve(0, n, leftRow, lowerDiagonal, upperDiagonal);
        return count;
    }

    // Recursive function to solve the N-Queens problem and update the count
    static void solve(int col, int n, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        // If we reach the last column, increment the count
        if (col == n) {
            count++;
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < n; row++) {
            // Check if the current position is available for placing a queen
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                // Mark the current row as unavailable for placing queens in subsequent columns
                leftRow[row] = 1;

                // Mark the lower diagonal as unavailable for placing queens in subsequent columns
                lowerDiagonal[row + col] = 1;

                // Mark the upper diagonal as unavailable for placing queens in subsequent columns
                upperDiagonal[n - 1 + col - row] = 1;

                // Recursively explore the next column
                solve(col + 1, n, leftRow, lowerDiagonal, upperDiagonal);

                // Backtrack: Undo the placement to explore other possibilities
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    // Main method to demonstrate the N-Queens solution
    public static void main(String args[]) {
        int N = 1;
        int solutions = totalNQueens(N);
        System.out.println("The number of distinct solutions for " + N + "-Queens puzzle is: " + solutions);
    }
}
