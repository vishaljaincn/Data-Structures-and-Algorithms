package day6_Introoduction_To_Arrays_2D_Matrices;

import java.util.Arrays;

/*
Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.

        Problem Constraints
        1<= N <= 1000
        1<= A[i][j] <= 1e9

        Input Format
        Only argument is a 2D array A of size N * N.

        Output Format
        Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
        The vacant spaces in the grid should be assigned to 0.

        Example Input
        Input 1:
        1 2 3
        4 5 6
        7 8 9
        Input 2:

        1 2
        3 4

        Example Output
        Output 1:
        1 0 0
        2 4 0
        3 5 7
        6 8 0
        9 0 0
        Output 2:

        1 0
        2 3
        4 0

 */
public class Anti_Diagonals {
    public static int[][] antiDiagonal(int[][] A) {
        int n = A.length;   //length of the input Array
        int[][] ans = new int[2 * n - 1][n];    //definition of Ans Array

        for (int col = 0; col < n; col++) { //iterating the columns as 1st element of each diagonal start from 0th row.
            int i = 0;    //row iteration variable
            int j = col;  //col iteration variable
            while (i < n && j >= 0) {   //OutOfBound condition checking
                ans[col][i] = A[i][j];
                i++;
                j--;
            }
        }
        for (int row = 1; row < n; row++) { //iterating the row as 1st element of each diagonal start from n-1 col.
            int i = row;    //row iteration variable
            int j = n - 1;    //col iteration variable
            while (i < n && j >= 0) {     //OutOfBound condition checking
                ans[i + j][i - row] = A[i][j];
                i++;
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(antiDiagonal(arr)));

    }
}
