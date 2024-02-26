package day70_Advanced_DP_1_One_Dimensional;

import java.util.Arrays;


// Time complexity: O(n), where n is the number of elements in the nums array.
// Space complexity: O(n), for the memoization array used for caching computed results.

public class HouseRobber_1_198_Memoization {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1); // Initialize memoization array with -1 as a marker for not computed values

        return robRecursive(nums, n - 1, memo);
    }

    private int robRecursive(int[] nums, int i, int[] memo) {
        if (i < 0) {
            return 0; // Base case: if there are no houses, return 0
        }

        if (memo[i] != -1) {
            return memo[i]; // Return the cached result if already computed
        }

        // Choose the maximum between robbing the current house and skipping it
        int result = Math.max(robRecursive(nums, i - 2, memo) + nums[i], robRecursive(nums, i - 1, memo));

        memo[i] = result; // Cache the result for future use
        return result;
    }
}
