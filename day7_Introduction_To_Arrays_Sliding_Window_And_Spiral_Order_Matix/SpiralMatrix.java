package day7_Introduction_To_Arrays_Sliding_Window_And_Spiral_Order_Matix;

import java.util.Arrays;

/*
Given an integer A, generate a square matrix filled with elements
from 1 to A2 in spiral order and return the generated square matrix.
 */
public class SpiralMatrix {
    public static int[][] generateMatrix(int A) {
        int n = A;
        int arr[][] = new int[n][n];
        int i = 0, j = 0, x = 1;
        while (n > 1) {
            // from left to right
            for (int k = 0; k < n - 1; k++) {
                arr[i][j] = x;
                x++;
                j++;
            }
            // from top to bottom
            for (int k = 0; k < n - 1; k++) {
                arr[i][j] = x;
                x++;
                i++;
            }
            // from right to left
            for (int k = 0; k < n - 1; k++) {
                arr[i][j] = x;
                x++;
                j--;
            }
            // from bottom to top
            for (int k = 0; k < n - 1; k++) {
                arr[i][j] = x;
                x++;
                i--;
            }
            i++;
            j++;
            n = n - 2;
        }
        if (n == 1) {
            arr[i][j] = x;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(5)));
    }
}
