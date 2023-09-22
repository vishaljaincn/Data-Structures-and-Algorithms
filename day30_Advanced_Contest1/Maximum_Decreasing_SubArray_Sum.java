package day30_Advanced_Contest1;

public class Maximum_Decreasing_SubArray_Sum {
    public static int maxDecreasingSubArraySum(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int maxSum = A[0]; // Initialize the maximum sum with the first element
        int currentSum = A[0]; // Initialize the current subarray sum with the first element

        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                currentSum += A[i]; // Add the current element to the current subarray sum
            } else {
                currentSum = A[i]; // Reset the current subarray sum
            }
            maxSum = Math.max(maxSum, currentSum); // Update the maximum sum if needed
        }

        return Math.max(maxSum, currentSum); // Return the maximum of the two sums
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 9, 9};
        int result = maxDecreasingSubArraySum(A);
        System.out.println("Maximum Decreasing Subarray Sum: " + result);
    }
}
