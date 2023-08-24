package day9_Introduction_To_Arrays_Contest_1;
/*
Given an array A of size N, and a 2D array of Q queries,where in each query a range from L to R is given, and
we need to find the count of Composite numbers in the given range and put them in an array and return it.
 */

import java.util.Arrays;

public class CompositeNumbersInTheGivenRange {
    public static int[] solve(int[] A, int[][] B) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 1; j * j <= A[i]; j++) {
                if (A[i] % j == 0) {
                    if (i == A[i] / j) {
                        count++;
                    } else {
                        count = count + 2;
                    }
                }
            }
            if (count > 2) {
                A[i] = 1;
            } else {
                A[i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            A[i] = A[i - 1] + A[i];
        }
        int Q = B.length;
        int[] arr = new int[Q];
        for (int i = 0; i < Q; i++) {
            int CompositeCount;
            int start = B[i][0];
            int end = B[i][1];
            if (start == 0) {
                CompositeCount = A[end];
            } else {
                CompositeCount = A[end] - A[start - 1];
            }
            arr[i] = CompositeCount;

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 20, 7, 32, 13}; // Example input array A
        int[][] B = {{0, 2}, {1, 4}, {2, 5}}; // Example query ranges
        System.out.println(Arrays.toString(solve(A, B)));

    }
}
