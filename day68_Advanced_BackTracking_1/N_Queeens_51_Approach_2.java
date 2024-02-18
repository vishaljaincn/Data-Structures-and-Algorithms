package day68_Advanced_BackTracking_1;

/*
N Queen Problem | Return all Distinct Solutions to the N-Queens Puzzle
Problem Statement: The n-queens is the problem of placing n queens on n × n chessboard such that no two queens can attack
each other. Given an integer n, return all distinct solutions to the n -queens puzzle. Each solution contains a distinct
boards configuration of the queen’s placement, where ‘Q’ and ‘.’ indicate queen and empty space respectively.

Examples:

Input: n = 4

Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

Explanation: There exist two distinct solutions to the 4-queens puzzle as shown below
 */
/*
Time Complexity: Exponential in nature since we are trying out all ways, to be precise it is O(N!).
                 total N! function calls

Space Complexity: O(N) Maximum Depth of the recursion tree(auxiliary space).
 */


import java.util.ArrayList;
import java.util.List;

class N_Queeens_51_Approach_2 {
    // Function to solve the N-Queens problem
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize the board with empty cells
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<>();

        // Arrays to keep track of the availability of rows and diagonals
        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2 * n - 1];
        int upperDiagonal[] = new int[2 * n - 1];

        // Start the recursive solving process
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    // Recursive function to solve the N-Queens problem
    static void solve(int col, char[][] board, List<List<String>> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        // If we reach the last column, add the current board configuration to the result
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < board.length; row++) {
            // Check if the current position is available for placing a queen
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                // Place the queen at the current position (row, col)
                board[row][col] = 'Q';

                // Mark the current row as unavailable for placing queens in subsequent columns
                leftRow[row] = 1;

                // Mark the lower diagonal as unavailable for placing queens in subsequent columns
                lowerDiagonal[row + col] = 1;

                // Mark the upper diagonal as unavailable for placing queens in subsequent columns
                upperDiagonal[board.length - 1 + col - row] = 1;

                // Recursively explore the next column
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);

                // Backtrack: Undo the placement to explore other possibilities
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    // Convert the board configuration to a list of strings
    static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    // Main method to demonstrate the N-Queens solution
    public static void main(String args[]) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }
}
