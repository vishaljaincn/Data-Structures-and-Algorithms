package day30_Advanced_Contest1;

/*
Given an array A of length n, write a function to find the absolute difference between the sum of elements to the left of
the current element and the sum of elements to the right of the current element. If there are no elements on the left or
right, their sum will be considered 0.
 */
public class Absolute_Difference_Left_And_Right {
    public int[] findAbsoluteDifference(int[] A) {
        int n = A.length;
        int[] prefixSum = new int[n];  // Array to store prefix sums
        int[] suffixSum = new int[n];  // Array to store suffix sums
        int[] result = new int[n];     // Array to store the absolute differences

        // Calculate the prefix sum of the array
        prefixSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        // Calculate the suffix sum of the array
        suffixSum[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + A[i];
        }

        // Calculate the absolute difference between prefix and suffix sums
        for (int i = 0; i < n; i++) {
            result[i] = Math.abs(prefixSum[i] - suffixSum[i]);
        }

        return result; // Return the array of absolute differences
    }
}
