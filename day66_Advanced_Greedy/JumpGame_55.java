package day66_Advanced_Greedy;

/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in
the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int reach = 0; // Initialize variable `reach` to store the furthest index we can reach
        for (int i = 0; i < nums.length; i++) {
            // If the current index `i` is beyond our reach, return false
            if (reach < i) {
                return false;
            }
            // Update `reach` to the maximum of its current value and the maximum index we can reach from `i`
            reach = Math.max(reach, i + nums[i]);
            // If `reach` is greater than or equal to the last index, we can reach the end
            if (reach >= nums.length - 1) {
                return true;
            }
        }
        // If we can iterate through the loop without returning false, return true
        return true;
    }
}
