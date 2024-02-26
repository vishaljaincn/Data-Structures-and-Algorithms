package day70_Advanced_DP_1_One_Dimensional;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

 */
/*
Time Complexity: O(N)

Reason: We are running a simple iterative loop

Space Complexity: O(n)

Reason: We are using memoization array.
 */

public class HouseRobber_1_198 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0]; // If there is only one house, return its value
        }

        int[] maxSum = new int[n];
        maxSum[0] = nums[0]; // Maximum sum for the first house is the value of the first house
        maxSum[1] = Math.max(nums[0], nums[1]); // Maximum sum for the second house is the maximum of the first two houses

        // Iterate from the third house to the end of the array
        for (int i = 2; i < n; i++) {
            // Choose the maximum between the sum excluding the current house and the sum including the current house
            maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + nums[i]);
        }

        return maxSum[n - 1]; // The final result is the maximum sum for the last house
    }
}
