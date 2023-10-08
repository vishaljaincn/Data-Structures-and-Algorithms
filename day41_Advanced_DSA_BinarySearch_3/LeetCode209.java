package day41_Advanced_DSA_BinarySearch_3;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 */
public class LeetCode209 {
    /*
    Time complexity: O(n). Single iteration of O(n).
Each element can be visited at most twice, once by the right pointer(end) and (at most)once by the left(start)s pointer.
     */
    public int minSubArrayLen(int target, int[] A) {
        int n = A.length;           // Get the length of the input array A.
        int start = 0;              // Initialize the start of the sliding window.
        int end = 0;                // Initialize the end of the sliding window.
        int curSum = 0;             // Initialize the current sum of elements in the window.
        int window = Integer.MAX_VALUE;  // Initialize the minimum window length, initially set to the maximum possible value.

        for (end = 0; end < n; end++) {
            curSum += A[end];       // Add the element at the 'end' index to the current sum.

            // While the current sum is greater than or equal to the target value,
            // update the window length and move the window's start to the right.
            while (curSum >= target) {
                window = Math.min(window, end - start + 1);  // Update the minimum window length.
                curSum -= A[start];     // Remove the element at the 'start' index from the current sum.
                start++;                // Move the window's start to the right.
            }
        }

        // If the 'window' is still equal to its initial value, it means no valid subarray was found.
        // Return 0 in this case; otherwise, return the minimum window length.
        return (window != Integer.MAX_VALUE) ? window : 0;
    }
}
