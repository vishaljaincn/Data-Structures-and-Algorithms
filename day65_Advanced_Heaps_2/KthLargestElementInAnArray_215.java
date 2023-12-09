package day65_Advanced_Heaps_2;

import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */
//TC - O(N * Log K)
//SC - O(K)
public class KthLargestElementInAnArray_215 {

    // Find the kth largest element in the array using a min heap
    public int KthLargestElementInAnArray_215(int[] nums, int k) {
        // Create a min heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first k elements to the min heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // Iterate over the remaining elements in the array
        for (int i = k; i < nums.length; i++) {
            int currentElement = nums[i];
            // If the current element is larger than the smallest element in the heap
            if (currentElement > minHeap.peek()) {
                // Remove the smallest element from the heap
                minHeap.poll();
                // Add the current element to the heap
                minHeap.offer(currentElement);
            } else {
                // If the new element is smaller or equal, ignore it
                // (since it won't affect the kth largest element in the array)
            }
        }

        // The peek of the min heap will be the kth largest element
        return minHeap.peek();
    }
}

