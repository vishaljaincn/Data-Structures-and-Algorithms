package day3_Introduction_To_Arrays_Prefix_Sum;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all
the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
// Time Complexity: O(n), where n is the length of the input array A
// Space Complexity: O(n), for the prefix, suffix, and result arrays

class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] A) {
        int n = A.length;

        // Arrays to store the prefix and suffix products
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        // Array to store the final result
        int result[] = new int[n];

        // Calculate prefix products
        prefix[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * A[i];
        }

        // Calculate suffix products
        suffix[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * A[i];
        }

        // Calculate the final product excluding the current element
        for (int i = 0; i < n; i++) {
            int temp = 1;

            // Multiply by the product of elements to the left (prefix)
            if (i > 0) {
                temp *= prefix[i - 1];
            }

            // Multiply by the product of elements to the right (suffix)
            if (i < n - 1) {
                temp *= suffix[i + 1];
            }

            // Store the result in the final array
            result[i] = temp;
        }

        return result;
    }
}
