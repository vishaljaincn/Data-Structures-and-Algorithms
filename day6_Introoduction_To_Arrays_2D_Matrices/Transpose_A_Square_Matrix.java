package day6_Introoduction_To_Arrays_2D_Matrices;

import java.util.Arrays;
/*
Can be Done Easily with the normal way of matrix transpose
 */
public class Transpose_A_Square_Matrix {
    public static int[][] transpose_A_Square_Matrix_Upper_Triangle(int A[][]) {
        int n = A.length;
//      TC - O(n^2) SC- O(1)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;
    }

    public static int[][] transpose_A_Square_Matrix_Lower_Triangle(int A[][]) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(transpose_A_Square_Matrix_Upper_Triangle(matrix)));
        System.out.println((Arrays.deepToString((transpose_A_Square_Matrix_Lower_Triangle(matrix2)))));
    }

}
