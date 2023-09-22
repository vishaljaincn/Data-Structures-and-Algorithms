package day35_Advanced_Merge_Sort;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing
the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To
accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in
nums1.
 */
public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for the last element in nums1
        int j = n - 1; // Pointer for the last element in nums2
        int k = m + n - 1; // Pointer for the position to insert the merged elements

        // Merge from the end to the beginning, comparing and placing the larger element at k
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]; // Place nums1[i] in the merged array
                i--; // Move the pointer i backwards in nums1
            } else {
                nums1[k] = nums2[j]; // Place nums2[j] in the merged array
                j--; // Move the pointer j backwards in nums2
            }
            k--; // Move the pointer k backwards
        }

        // If there are remaining elements in nums2, add them to the beginning of nums1
        while (j >= 0) {
            nums1[k] = nums2[j]; // Add remaining nums2 elements to nums1
            j--; // Move the pointer j backwards in nums2
            k--; // Move the pointer k backwards
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[6]; // Create an array with enough space for merging
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;

        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        // Call the merge method to merge nums1 and nums2
        merge(nums1, m, nums2, n);

        // Print the merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
