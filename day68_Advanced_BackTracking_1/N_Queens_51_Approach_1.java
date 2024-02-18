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
Time Complexity: Exponential in nature since we are trying out all ways, to be precise it is O(N! * N).
                 total N! function calls and validate method takes N time

Space Complexity: O(N) Maximum Depth of the recursion tree(auxiliary space).
 */

import java.util.ArrayList;
import java.util.List;

class N_Queens_51_Approach_1 {
    // Function to solve the N-Queens problem
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // Initialize the board with empty cells
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res); // Start the depth-first search from the first column
        return res;
    }


    // Recursive depth-first search to explore all possible solutions
    static void dfs(int col, char[][] board, List<List<String>> res) {
        // If we reach the last column, add the current board configuration to the result
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                // If the placement is valid, update the board and continue the search
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                // Backtrack: Undo the placement to explore other possibilities
                board[row][col] = '.';
            }
        }
    }

    // Helper function to check if placing a queen at a specific position is valid
    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;

        // Check the upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;

        // Check the same row to the left
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;

        // Check the lower-left diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }

        // If no conflicts, the placement is valid
        return true;
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
