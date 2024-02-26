package day70_Advanced_DP_1_One_Dimensional;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 */
/*
Time Complexity: O(N )

Reason: We are running a simple iterative loop, two times. Therefore total time complexity will be O(N) + O(N) ≈ O(N)

Space Complexity: O(1)

Reason: We are not using extra space.
 */

public class HouseRobber_2_213 {

    // Main function to solve the House Robber problem for circular arrangement
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        // If there is only one house, return its value
        if (n == 1) {
            return nums[0];
        }

        // Case 1: Rob houses from the first house to the second-to-last house
        int maxSum1 = robHelper(nums, 0, n - 2);

        // Case 2: Rob houses from the second house to the last house
        int maxSum2 = robHelper(nums, 1, n - 1);

        // Return the maximum result between the two cases
        return Math.max(maxSum1, maxSum2);
    }

    // Helper function to apply the House Robber algorithm on a subarray
    private int robHelper(int[] nums, int start, int end) {
        int n = end - start + 1;

        // If there is only one house in the subarray, return its value
        if (n == 1) {
            return nums[start];
        }

        // Create an array to store the maximum sum for each house in the subarray
        int[] maxSum = new int[n];
        maxSum[0] = nums[start];
        maxSum[1] = Math.max(nums[start], nums[start + 1]);

        // Apply the House Robber algorithm on the subarray
        for (int i = 2; i < n; i++) {
            // Choose the maximum between the sum excluding the current house
            // and the sum including the current house
            maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + nums[start + i]);
        }

        // Return the maximum sum for the last house in the subarray
        return maxSum[n - 1];
    }
}
