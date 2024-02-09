package day42_Advanced_Hashing_1;


import java.util.HashSet;
import java.util.Set;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */
/*
 * Time Complexity: O(m + n), where m and n are the lengths of nums1 and nums2.
 *                   Iterating through both arrays to create HashSet and find the intersection.
 * Space Complexity: O(min(m, n)), where m and n are the lengths of nums1 and nums2.
 *                    The space required for the HashSet storing unique elements from nums1.
 */

public class IntersectionOfTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Create HashSet to store unique elements from nums1
        Set<Integer> set1 = new HashSet<>();
        // Create HashSet to store the intersection of nums1 and nums2
        Set<Integer> resultSet = new HashSet<>();

        // Add elements from nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Check for intersection with nums2 and add unique elements to the resultSet
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert the resultSet to an array for the desired output format
        int[] resultArray = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            resultArray[index++] = num;
        }

        return resultArray;
    }
}
