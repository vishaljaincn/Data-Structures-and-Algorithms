package leetcode_Extra;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j
in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

 */
// Time complexity: O(n) - where n is the length of the input array
// Space complexity: O(min(n, k)) - space used by the HashMap with a bounded size

class ContainsDuplicate_II_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Use a map to store the last seen index of each element
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is already in the map
            if (lastIndexMap.containsKey(nums[i])) {
                // If the absolute difference between indices is at most k, return true
                if (i - lastIndexMap.get(nums[i]) <= k) {
                    return true;
                }
            }

            // Update the index of the current element in the map
            lastIndexMap.put(nums[i], i);
        }

        // No such indices found
        return false;
    }
}
