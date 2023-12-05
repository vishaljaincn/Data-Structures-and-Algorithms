package leetcode_Extra;

/*
Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment n - 1 elements of the array by 1.

Example 1:

Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
Example 2:

Input: nums = [1,1,1]
Output: 0
 */
class MinMoves_453 {
    public int minMoves(int[] nums) {

        // Find the minimum element in the array
        int minElement = Integer.MAX_VALUE; // Initialize with the maximum possible integer value

        for (int num : nums) {
            minElement = Math.min(minElement, num);
        }

        // Calculate the sum of differences between each element and the minimum element
        int moves = 0;
        for (int num : nums) {
            moves += (num - minElement);
        }

        return moves;
    }
}
