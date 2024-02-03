package day7_Introduction_To_Arrays_Sliding_Window_And_Spiral_Order_Matix;

/*
A swap is defined as taking two distinct positions in an array and swapping the values in them.
A circular array is defined as an array where we consider the first element and the last element to be adjacent.
Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the
array together at any location.
Example 1:

Input: nums = [0,1,0,1,1,0,0]
Output: 1
Explanation: Here are a few of the ways to group all the 1's together:
[0,0,1,1,1,0,0] using 1 swap.
[0,1,1,1,0,0,0] using 1 swap.
[1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
There is no way to group all 1's together with 0 swaps.
Thus, the minimum number of swaps required is 1.
Example 2:

Input: nums = [0,1,1,1,0,0,1,1,0]
Output: 2
Explanation: Here are a few of the ways to group all the 1's together:
[1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
[1,1,1,1,1,0,0,0,0] using 2 swaps.
There is no way to group all 1's together with 0 or 1 swaps.
Thus, the minimum number of swaps required is 2.
Example 3:

Input: nums = [1,1,0,0,1]
Output: 0
Explanation: All the 1's are already grouped together due to the circular property of the array.
Thus, the minimum number of swaps required is 0.
 */
//Time complexity - O(N)
public class MinimumSwapsToGroupAllOnesTogether_II_2134 {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Counting all the 1's
        int countOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                countOnes++;
            }
        }

        // Edge cases
        if (countOnes == 0 || countOnes == 1) {
            // If there are no 1's or only one 1, no swaps are needed, so the result is 0.
            return 0;
        }

        // Checking the first window
        int bad = 0;
        for (int i = 0; i < countOnes; i++) {
            if (nums[i] == 0) {
                bad++;
            }
        }

        // Initialize the answer with the bad count in the first window
        int ans = bad;

        // Sliding window approach
        for (int i = 1; i < n; i++) {
            // Update the bad count for the circular array
            if (nums[(i - 1) % n] == 0) {
                bad--;
            }
            if (nums[(i + countOnes - 1) % n] == 0) {
                bad++;
            }
            ans = Math.min(ans, bad);
        }

        return ans;
    }
}