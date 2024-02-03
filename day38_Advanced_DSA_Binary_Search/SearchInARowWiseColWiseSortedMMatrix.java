package day38_Advanced_DSA_Binary_Search;

/*
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */

//O(log(m * n)) time complexity
class SearchInARowWiseColWiseSortedMMatrix {
    // Function to search for an element in a matrix
    public boolean searchMatrix(int[][] A, int B) {
        // Get the number of rows in the matrix
        int n = A.length;

        // Get the number of columns in the matrix
        int m = A[0].length;

        // Initialize low and high for binary search
        int low = 0;
        int high = (n * m) - 1;

        // Binary search loop
        while (low <= high) {
            // Calculate mid index
            int mid = (low + high) / 2;

            // Calculate row and column indices from mid index
            int i = mid / m;
            int j = mid % m;

            // Check if the element at the calculated indices is equal to the target
            if (A[i][j] == B) {
                // If found, return true
                return true;
            } else if (A[i][j] < B) {
                // If the element is less than the target, narrow the search to the right
                low = mid + 1;
            } else {
                // If the element is greater than the target, narrow the search to the left
                high = mid - 1;
            }
        }

        // If the target is not found in the matrix, return false
        return false;
    }
}
