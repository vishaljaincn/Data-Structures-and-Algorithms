package leetcode_Extra;

import java.util.Arrays;
/*
Given an array of intervals intervals where intervals[i] = [start i, end i], return the minimum
number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */

/**
 * Time Complexity: O(n log n)
 * - Sorting the intervals takes O(n log n).
 * - Iterating through the intervals takes O(n).
 * <p>
 * Space Complexity: O(1)
 * - The space complexity is constant as we are using a fixed amount of extra space regardless of the input size.
 */
public class NonOverLappingIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Edge case: if there are no intervals, no need to remove any
        if (intervals.length == 0) return 0;

        // Sort the intervals based on their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;  // Counter to track the number of intervals to remove
        int end = intervals[0][1];  // Initialize end time to the end of the first interval

        // Iterate through the sorted intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts before the end of the previous interval, they overlap
            if (intervals[i][0] < end) {
                count++;  // Increment the count of intervals to remove
            } else {
                // Otherwise, update the end time to the end of the current interval
                end = intervals[i][1];
            }
        }

        // Return the count of intervals to remove
        return count;
    }
}
