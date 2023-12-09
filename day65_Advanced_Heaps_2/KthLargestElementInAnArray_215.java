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
 */
//Time Complexity: O(N log K)
//Space Complexity: O(K)
class KthLargestElementInAnArray_215 {

    public int findKthLargest(int[] nums, int k) {

        // Create a min-heap PriorityQueue
        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Iterate through each element in the array
        for (int val : nums) {
            // Add the current element to the PriorityQueue
            pq.offer(val);

            // If the size of PriorityQueue exceeds k, remove the smallest element
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // The top of the PriorityQueue will be the kth largest element
        return pq.peek();
    }
}
