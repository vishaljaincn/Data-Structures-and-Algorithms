package leetcode_Extra;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the
non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 */
// Time complexity: O(n) - where n is the length of the input array
// Space complexity: O(1) - constant space used, as it operates in-place

class MoveZeros_283 {
    // Function to move all zeroes to the end without changing the order of non-zero elements
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return; // No need to move elements in an array of size 1
        }

        int nonZeroIndex = 0;

        // Iterate through the array to move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // Fill the remaining positions with zeros
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }
}
