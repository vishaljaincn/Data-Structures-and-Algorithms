package day6_Introoduction_To_Arrays_2D_Matrices;

import java.util.Arrays;

public class Make_Entire_ith_row_and_jth_Column_Zero {
    public static int[][] make_Entire_ith_row_and_jth_Column_Zero(int[][] A) {
        int n = A.length;    // Number of rows
        int m = A[0].length; // Number of columns

        // Space complexity - O(n+m)
        // Arrays to store the rows and columns to be updated
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        // Time complexity - O(n*m)
        // Identify rows and columns to be updated
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Update the matrix based on the identified rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || cols[j]) {
                    A[i][j] = 0;
                }
            }
        }

        return A; // Return the modified matrix
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 0},
                {9, 2, 0, 4}};
        System.out.println(Arrays.deepToString(make_Entire_ith_row_and_jth_Column_Zero(arr)));
    }

}
