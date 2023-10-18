package day45_Advanced_DSA_Two_Pointers;

import java.util.Arrays;

/*
Given an int array nums and an int target. Find two integers in nums such that the sum is closest to target.

Example 1:

Input: nums = [1, 2, 3, 4, 5], target = 10
Output: [4, 5]
Example 2:

Input: nums= [-1, 2, 1, -4], target = 4
Output: [2, 1]
 */
public class TwoSumClosest {
    // Function to find two integers in nums with the sum closest to target
    public static int[] findClosestPairArray(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array in ascending order
        int left = 0; // Initialize the left pointer
        int right = nums.length - 1; // Initialize the right pointer
        int[] result = {-1, -1}; // Initialize the result array
        int closestSum = Integer.MAX_VALUE; // Initialize the closestSum to a large positive value

        // Loop to search for the pair with the closest sum to the target
        while (left < right) {
            int currentSum = nums[left] + nums[right]; // Calculate the sum of the current pair
            if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                // If the current pair has a closer sum to the target, update closestSum and result
                closestSum = currentSum;
                result[0] = nums[left];
                result[1] = nums[right];
            }
            if (currentSum < target) {
                // If the current sum is less than the target, move the left pointer to the right
                left++;
            } else {
                // If the current sum is greater than or equal to the target, move the right pointer to the left
                right--;
            }
        }
        return result; // Return the result containing the pair with the closest sum to the target
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(findClosestPairArray(A, 10))); // Test the function with Example 1
        int B[] = {-1, 2, 1, -4};
        System.out.println(Arrays.toString(findClosestPairArray(B, 4))); // Test the function with Example 2
    }
}
