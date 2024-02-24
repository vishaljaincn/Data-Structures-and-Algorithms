package leetcode_Extra;
/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each
number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

// Time complexity: O(n), where n is the length of the input array
// Space complexity: O(n), for the result array
class SquaresOfASortedArray_977 {
    public int[] sortedSquares(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // Initialize an array to store the sorted squares
        int[] result = new int[n];

        // Initialize pointers for the left and right ends of the array
        int left = 0;
        int right = n - 1;

        // Initialize an index for the result array, starting from the end
        int index = n - 1;

        // Traverse the array from both ends using two pointers
        while (left <= right) {
            // Calculate the squares of the elements at the left and right pointers
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            // Compare the squares and place the larger square at the end of the result array
            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                // Move the left pointer to the next element
                left++;
            } else {
                result[index] = rightSquare;
                // Move the right pointer to the previous element
                right--;
            }

            // Move the index towards the beginning of the result array
            index--;
        }

        // Return the sorted squares array
        return result;
    }
}
