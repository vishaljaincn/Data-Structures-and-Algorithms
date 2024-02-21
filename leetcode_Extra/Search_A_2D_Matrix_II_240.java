package leetcode_Extra;

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example 1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 */
// Time complexity: O(m + n) where m is the number of rows and n is the number of columns in the matrix.
// Space complexity: O(1) as the algorithm uses constant space for variables and does not require additional data structures.


public class Search_A_2D_Matrix_II_240 {
    // Function to search for a target value in a sorted 2D matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        // Check for edge cases: empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // Get the number of rows and columns in the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner of the matrix
        int row = 0;
        int col = cols - 1;

        // Iterate until we are within the bounds of the matrix
        while (row < rows && col >= 0) {
            // Get the current element in the matrix
            int current = matrix[row][col];

            // Check if the current element is equal to the target
            if (current == target) {
                return true; // Target found
            } else if (current < target) {
                // If current value is less than target, move to the next row
                row++;
            } else {
                // If current value is greater than target, move to the previous column
                col--;
            }
        }

        // If we reach this point, the target is not present in the matrix
        return false;
    }
}