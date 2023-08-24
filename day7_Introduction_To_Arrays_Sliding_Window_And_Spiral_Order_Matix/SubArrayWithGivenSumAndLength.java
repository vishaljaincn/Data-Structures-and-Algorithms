package day7_Introduction_To_Arrays_Sliding_Window_And_Spiral_Order_Matix;

/*
Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 */
public class SubArrayWithGivenSumAndLength {
    public static int solve(int[] A, int B, int C) {
        int n = A.length;
        int sum = 0;
        // Calculating first Windoow
        for (int i = 0; i < B; i++) {
            sum = sum + A[i];
        }
        if (sum == C) {
            return 1;
        }
        // Sliding Window Approach
        int start = 1, end = B;
        while (end < n) {
            sum = sum - A[start - 1] + A[end];
            if (sum == C) {
                return 1;
            }
            start++;
            end++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[]={4, 3, 2, 6, 1};
        System.out.println(solve(arr,3,11));
    }
}
