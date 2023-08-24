package day6_Introoduction_To_Arrays_2D_Matrices;

public class MatrixTransposeOfSquareMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] transpose = transposeMatrix(matrix);

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        System.out.println("\nTransposed Matrix:");
        printMatrix(transpose);
    }
//
    public static int[][] transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] transpose = new int[n][n];
//      TC - O(n^2) SC- O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }

        return transpose;
    }

    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
