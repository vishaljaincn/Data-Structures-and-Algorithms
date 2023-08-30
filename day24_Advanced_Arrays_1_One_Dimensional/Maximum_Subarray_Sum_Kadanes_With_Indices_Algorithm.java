package day24_Advanced_Arrays_1_One_Dimensional;

import java.util.Arrays;

public class Maximum_Subarray_Sum_Kadanes_With_Indices_Algorithm {
    // This function calculates the maximum sum of a subarray within the given array.
    public static int maxSubArray(final int[] A) {
        int currentSum = 0;
        int finalSum = Integer.MIN_VALUE;
        int start = 0; // Variable to keep track of the starting index of the maximum subarray.
        int end = 0;   // Variable to keep track of the ending index of the maximum subarray.
        int tempStart = 0; // Temporary variable to keep track of the starting index of the current subarray.

        for (int i = 0; i < A.length; i++) {
            currentSum = currentSum + A[i];

            if (currentSum > finalSum) {
                finalSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        System.out.println("Start index: " + start);
        System.out.println("End index: " + end);
        int res[] = new int[end - start + 1];
        System.arraycopy(A, start, res, 0, res.length);
        System.out.println(Arrays.toString(res));
        return finalSum;
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + maxSubArray(arr));
    }
}
