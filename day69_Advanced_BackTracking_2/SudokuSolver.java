package day69_Advanced_BackTracking_2;

/*
Time Complexity:
The time complexity is exponential, roughly O(9^(n^2)), where 'n' is the size of the Sudoku board
(typically 9 for a standard Sudoku puzzle).
This is due to the backtracking algorithm exploring all possible combinations of digits for each empty cell.

Space Complexity:
The space complexity is O(n^2), where 'n' is the size of the Sudoku board.
This is primarily determined by the maximum depth of the recursion stack, which is proportional to the number of empty cells
in the puzzle. In the worst case, it's at most 81 for a standard 9x9 Sudoku puzzle.
 */
class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Main solving function using backtracking
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // If the current cell is empty, try placing a digit
                if (board[row][col] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isValid(board, row, col, digit)) {
                            // Place the digit and move to the next cell
                            board[row][col] = digit;

                            // Recursively solve the rest of the puzzle
                            if (solve(board)) {
                                return true; // Solution found
                            }

                            // If placing the current digit didn't lead to a solution, backtrack
                            board[row][col] = '.'; // Undo the placement
                        }
                    }
                    return false; // No valid digit found for this cell
                }
            }
        }
        return true; // All cells are filled, solution found
    }

    // Helper function to check if a digit can be placed in a given cell
    private boolean isValid(char[][] board, int row, int col, char digit) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int subgridRow = 3 * (row / 3);
        int subgridCol = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[subgridRow + i][subgridCol + j] == digit) {
                    return false;
                }
            }
        }

        return true; // Digit can be placed in the cell
    }
}
