package day14_Interview_Problems;
/*
Given an array of integers A and multiple values in B, which represents the number of times array A needs to be
left rotated.

Find the rotated array for each value and return the result in the from of a matrix where ith row represents the
rotated array for the ith value in B.
 */

import java.util.Arrays;

public class Multiple_Left_Rotations_Of_The_Array {
    public static int[][] solve(int[] A, int[] B) {
        int[][] finalMatrix = new int[B.length][A.length];
        for (int i = 0; i < B.length; i++) {
            int k = B[i];
            int[] newArray = new int[A.length];

            // Creating a copy of the original array A
            for (int j = 0; j < A.length; j++) {
                newArray[j] = A[j];
            }

            int n = A.length;
            if (k > n) {
                k = k % n;
            }
            if (n == k || k == 0) {
                // If k is equal to length of the array or 0, no rotation needed
                for (int x = 0; x < n; x++) {
                    finalMatrix[i][x] = newArray[x];
                }
            } else {
                // Reversing the entire array
                int temp;
                int j = n - 1;
                for (int y = 0; y < j; y++, j--) {
                    temp = newArray[y];
                    newArray[y] = newArray[j];
                    newArray[j] = temp;
                }

                // Reversing from 0 to n-k-1
                j = n - k - 1;
                for (int y = 0; y < j; y++, j--) {
                    temp = newArray[y];
                    newArray[y] = newArray[j];
                    newArray[j] = temp;
                }

                // Reversing from n-k to n-1
                int x = n - 1;
                for (int y = n - k; y < x; y++, x--) {
                    temp = newArray[y];
                    newArray[y] = newArray[x];
                    newArray[x] = temp;
                }

                // Copying the rotated array to the finalMatrix
                for (int u = 0; u < n; u++) {
                    finalMatrix[i][u] = newArray[u];
                }
            }
        }
        return finalMatrix;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int arr2[] = {2, 3};
        int[][] result = solve(arr, arr2);

        System.out.println(Arrays.deepToString(solve(arr, arr2)));
    }
}
