package day42_Advanced_Hashing_1;
/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear
as many times as it shows in both arrays and you may return the result in any order.
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time complexity: O(m + n), where m and n are the lengths of nums1 and nums2, respectively.
// Space complexity: O(min(m, n)), the space used by the frequency map.

public class IntersectionOfTwoArrays_350 {
    // Method to find the intersection of two arrays
    public int[] intersect(int[] nums1, int[] nums2) {
        // Use HashMap to store the frequency of each number in nums1
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Populate the frequency map for nums1
        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // List to store the intersection elements
        List<Integer> result = new ArrayList<>();

        // Iterate through nums2 and check the frequency in the HashMap
        for (int num : nums2) {
            // If num exists in freqMap and its frequency is greater than 0
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                // Add num to the result list
                result.add(num);
                // Decrement the frequency of num in freqMap
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }

        // Convert the List to an array
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        // Return the array of intersection elements
        return intersection;
    }
}
