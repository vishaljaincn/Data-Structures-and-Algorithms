package day13_Sorting;

import java.util.Arrays;

/*
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
Example 1:
Input: nums = [1,2,3]
Output: 6
Example 2:
Input: nums = [1,2,3,4]
Output: 24
Example 3:
Input: nums = [-1,-2,-3]
Output: -6
 */
//Time complexity: O(n log n), Space complexity: O(1)
public class MaximumProductOf3Numbers_628 {

    public int maximumProduct(int[] nums) {
        // Step 1: Sort the input array in ascending order
        Arrays.sort(nums);

        // Step 2: Calculate the two possible products
        int n = nums.length;

        // Case 1: Product of the three largest numbers
        int productCase1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Case 2: Product of the two smallest numbers (potentially negative) and the largest number
        int productCase2 = nums[0] * nums[1] * nums[n - 1];

        // Step 3: Return the maximum of the two cases
        return Math.max(productCase1, productCase2);
    }
}
