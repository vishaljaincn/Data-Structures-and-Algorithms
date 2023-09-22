package day26_Advanced_Arrays_3_Interview_Problems;
/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of
the non-overlapping intervals that cover all the intervals in the input.
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverLappingIntervals {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // Check if the current interval overlaps with the next interval
            if (currentInterval[1] >= nextInterval[0]) {
                // Merge the intervals
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // Add the current interval to the result and update the current interval
                result.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // Add the last interval to the result
        result.add(currentInterval);

        // Convert the list to an array
        return result.toArray(new int[result.size()][2]);
    }
}