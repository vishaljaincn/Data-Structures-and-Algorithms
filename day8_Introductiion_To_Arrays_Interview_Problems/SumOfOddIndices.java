package day8_Introductiion_To_Arrays_Interview_Problems;

import java.util.Arrays;

/*
You are given an array A of length N and Q queries given by the 2D array B of size Q*2.
Each query consists of two integers B[i][0] and B[i][1].
For every query, the task is to calculate the sum of all odd indices in the range A[B[i][0]…B[i][1]].

 */
public class SumOfOddIndices {
    public static int[] solve(int[] A, int[][] B) {
        // Calculate the Prefix Sum(cumulative sum without creating a new array) of only odd Indices
        int n = A.length;
        // Below condition needs to be handled explicitly
        A[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                A[i] = A[i - 1] + A[i];
            } else {
                A[i] = A[i - 1];
            }
        }
        int Query = B.length;
        int arr[] = new int[Query];
        for (int i = 0; i < Query; i++) {
            int start = B[i][0];
            int end = B[i][1];
            if (start == 0) {
                arr[i] = A[end];
            } else {
                arr[i] = A[end] - A[start - 1];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {{0, 2}, {1, 4}};
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
