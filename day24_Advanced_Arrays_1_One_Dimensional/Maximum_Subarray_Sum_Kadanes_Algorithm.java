package day24_Advanced_Arrays_1_One_Dimensional;

/*
Find the maximum sum of contiguous non-empty subarray within an array A of length N.
 */
public class Maximum_Subarray_Sum_Kadanes_Algorithm {
    // This function calculates the maximum sum of a subarray within the given array.
    // The argument 'A' is the input array. It is marked as 'final' to indicate that the array itself will not be modified.
    public static int maxSubArray(final int[] A) {
        // Initialize variables to keep track of the current sum and the final maximum sum.
        int currentSum = 0;      // Keeps track of the sum of the current subarray being considered.
        int finalSum = Integer.MIN_VALUE;  // Stores the maximum sum found so far.

        // Iterate through the elements of the input array.
        for (int i = 0; i < A.length; i++) {
            // Add the current element to the current sum.
            currentSum = currentSum + A[i];

            // If the current sum is greater than the final maximum sum,
            // update the final maximum sum with the current sum.
            if (currentSum > finalSum) {
                finalSum = currentSum;
            }

            // If the current sum becomes negative, reset it to zero.
            // This is because a negative current sum indicates that continuing
            // the current subarray won't yield a maximum sum.
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Return the maximum sum of a subarray found in the input array.
        return finalSum;
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
