package day6_Introoduction_To_Arrays_2D_Matrices;

import java.util.Arrays;

public class MatrixTransposeOfSize_N_cross_M {
    public static int[][] matrixTranspose(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = A[j][i];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(matrixTranspose(arr)));
    }
}
