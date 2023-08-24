package day6_Introoduction_To_Arrays_2D_Matrices;

import java.util.Arrays;

public class Rotate_Square_Matrix_By_90_degree {
    public static void solve(int[][] A) {
        int n = A.length;
//        Transpose the Square_matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
//        Reverse_Each_Row of the Square matrix
        for(int i=0;i<n;i++)
        {
            for(int start=0,end=n-1;start<end;start++,end--)
            {
                int temp =A[i][start];
                A[i][start]=A[i][end];
                A[i][end]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solve(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
