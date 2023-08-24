package day7_Introduction_To_Arrays_Sliding_Window_And_Spiral_Order_Matix;

/*
Given an array of size N, find the subArray of size K with the least average.

Input Format
First argument contains an array A of integers of size N.
Second argument contains integer k.

Output Format
Return the index of the first element of the subArray of size k that has least average.
Array indexing starts from 0.
 */
public class SubArrayWithLeastAverage {
    public static int solve(int[] A, int B) {
        int n = A.length;
        // Average for any particular subarray is sum_of_elements/no_of_elements.
        // In this no. of elements is same in each subarray as we have to find only subarray of size k.
        // So now question reduces to find subarray which has miniumm sum.

        // calculating first window(first subarray sum of length B)
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum = sum + A[i];
        }
        int leastsum = sum;
        int firstIndexOfSubarrayThatHasLeastSum = 0;
        // Sliding Window Approach
        int start = 1, end = B;
        while (end < n) {
            sum = sum - A[start - 1] + A[end];
            if (sum < leastsum) {
                leastsum = sum;
                firstIndexOfSubarrayThatHasLeastSum = start;
            }
            start++;
            end++;
        }
        return firstIndexOfSubarrayThatHasLeastSum;
    }

    public static void main(String[] args) {
        int arr[]={3, 7, 90, 20, 10, 50, 40};
        System.out.println(solve(arr,3));
    }
}
