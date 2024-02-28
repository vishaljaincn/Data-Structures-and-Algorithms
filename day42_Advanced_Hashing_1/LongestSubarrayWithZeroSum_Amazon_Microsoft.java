package day42_Advanced_Hashing_1;
/*
 Given an array containing both positive and negative integers, we have to find the length of the longest subarray
 with the sum of all elements equal to zero.
 */

import java.util.HashMap;

// Time complexity: O(n), where n is the length of the input array
// Space complexity: O(n), for the HashMap storing sum and index pairs
public class LongestSubarrayWithZeroSum_Amazon_Microsoft {

    // Function to find the length of the longest subarray with zero sum
    public static int findMaxLength(int[] nums) {
        // HashMap to store the running sum and its corresponding index
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        // Variable to store the maximum length of subarray with zero sum
        int maxLength = 0;
        // Variable to track the running sum
        int sum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Update the running sum
            sum += nums[i];

            // Check if the current sum is zero, update maxLength
            if (sum == 0) {
                maxLength = i + 1;
            }
            // Check if the current sum is encountered before
            else if (sumIndexMap.containsKey(sum)) {
                // Update maxLength by comparing with the length between current and previous occurrence
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));
            }
            // If the current sum is not encountered before, add it to the HashMap
            else {
                sumIndexMap.put(sum, i);
            }
        }

        // Return the maximum length of subarray with zero sum
        return maxLength;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example array
        int[] nums = {1, -1, 3, 2, -2, -8, 1, 7, 10};
        // Find and print the length of the longest subarray with zero sum
        int result = findMaxLength(nums);
        System.out.println("Length of longest subarray with zero sum: " + result);
    }
}
