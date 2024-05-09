package day66_Advanced_Greedy;
/*
Given an array of non-negative integers arr, you are initially positioned at start index of the array.
When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

Notice that you can not jump outside of the array at any time.

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

 */

import java.util.LinkedList;
import java.util.Queue;

// Time complexity: O(n), where n is the length of the array
// Space complexity: O(n), where n is the length of the array
class JumpGame_III_1306 {
    public static boolean canReach(int[] arr, int start) {
        int n = arr.length; // Length of the array
        Queue<Integer> q = new LinkedList<>(); // Queue to perform BFS

        // Add the starting index to the queue
        q.add(start);

        // Perform BFS
        while (!q.isEmpty()) {
            int curr = q.poll(); // Retrieve the current index from the queue

            if (arr[curr] == 0)
                return true; // If the value at the current index is 0, we have reached the target index

            if (arr[curr] < 0)
                continue; // If the value at the current index is negative, this index has already been visited from another path

            // Add the indices reachable from the current index
            if (curr + arr[curr] < n)
                q.add(curr + arr[curr]); // Add index reachable by moving right
            if (curr - arr[curr] >= 0)
                q.add(curr - arr[curr]); // Add index reachable by moving left

            arr[curr] = -arr[curr]; // Mark the current index as visited by making its value negative
        }

        return false; // If the target index cannot be reached
    }
}
