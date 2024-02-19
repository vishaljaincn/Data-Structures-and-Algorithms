package day55_Advanced_Stacks_2;

import java.util.Stack;

/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray
of arr. Since the answer may be large, return the answer modulo 109 + 7.

Example 1:
Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

Example 2:
Input: arr = [11,81,94,43,3]
Output: 444
 */
// Time complexity: O(n)
// Space complexity: O(n)

class SumOfSubArrayMinimums_907 {
    // Method to calculate the sum of minimum values of subarrays
    public int sumSubarrayMins(int[] arr) {
        // Define a constant for modulo operation
        int mod = 1000000007;
        // Get the length of the input array
        int n = arr.length;

        // Create a stack to track indices
        Stack<Integer> s = new Stack<>();

        // Arrays to store left and right indices for each element
        int[] left = new int[n];
        int[] right = new int[n];

        // Loop through the array to calculate left indices
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the current element is smaller
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            // If the stack is empty, set left index to -1, otherwise use the top of the stack
            if (s.empty()) {
                left[i] = -1;
            } else {
                left[i] = s.peek();
            }
            // Add the current index to the stack
            s.add(i);
        }

        // Clear the stack for the next set of calculations
        s.clear();

        // Loop through the array in reverse to calculate right indices
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack while the current element is smaller
            while (!s.empty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            // If the stack is empty, set right index to n, otherwise use the top of the stack
            if (s.empty()) {
                right[i] = n;
            } else {
                right[i] = s.peek();
            }
            // Add the current index to the stack
            s.add(i);
        }

        // Variable to store the result of the summation
        long result = 0;

        // Loop through the array to calculate contributions and update the result
        for (int i = 0; i < n; i++) {
            // Calculate the contribution of the current element to the result
            long contribution = ((long) arr[i] * (i - left[i]) * (right[i] - i)) % mod;
            // Update the result using the calculated contribution
            result = (result + contribution + mod) % mod;
        }

        // Return the result as an integer
        return (int) result;
    }
}
