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

class HouseRobber_2_213 {
    // Main method to calculate the maximum amount that can be robbed in a circular arrangement of houses.
    public int rob(int[] nums) {
        int n = nums.length;

        // If there is only one house, return the value of that house.
        if (n == 1)
            return nums[0];

        // Create two arrays to represent two cases: one where the first house is included, and one where it is excluded.
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];

        // Populate the two arrays based on the original input array.
        for (int i = 0; i < n; i++) {
            if (i != 0)
                nums1[i] = nums[i];
            if (i != n - 1)
                nums2[i] = nums[i];
        }

        // Calculate the maximum amount that can be robbed in each case and return the maximum of the two.
        int ans1 = solve(nums1);
        int ans2 = solve(nums2);

        return Math.max(ans1, ans2);
    }

    // Helper method to calculate the maximum amount that can be robbed in a linear arrangement of houses.
    public static int solve(int[] nums) {
        int n = nums.length;

        // Initialize variables to keep track of the maximum amounts at the current and previous positions.
        int prev = nums[0];
        int prev2 = 0;

        // Iterate through the array starting from the second element.
        for (int i = 1; i < n; i++) {
            // Calculate the maximum amount by either picking the current element or not picking it.
            int pick = nums[i];
            if (i > 1)
                pick += prev2;
            int notPick = 0 + prev;

            // Update the current maximum amount and move the pointers for the next iteration.
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }

        // The final value of 'prev' now holds the maximum amount that can be robbed.
        return prev;
    }
}
