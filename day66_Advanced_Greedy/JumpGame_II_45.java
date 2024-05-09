package day66_Advanced_Greedy;
/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 */
// Time Complexity: O(n)
//   - The algorithm has a linear time complexity since it iterates through the array only once.
// Space Complexity: O(1)
//   - The algorithm uses only a constant amount of extra space regardless of the input size.
class JumpGame_II_45 {
    public int jump(int[] nums) {
        // Initialize pointers and step counter
        int left = 0, right = 0, step = 0;

        // Loop until we reach the last index or beyond
        while (right < nums.length - 1) {
            // Initialize the maximum reachable index within the current range
            int max = 0;

            // Iterate over the current range to find the maximum reachable index
            for (int i = left; i <= right; i++) {
                // Update the maximum reachable index
                max = Math.max(max, nums[i] + i);
            }

            // Move the left pointer to the next range starting index
            left = right + 1;

            // Update the right pointer to the maximum reachable index within the new range
            right = max;

            // Increment the step counter
            step++;
        }

        // Return the total number of steps taken to reach the end
        return step;
    }
}
