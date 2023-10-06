package day40_Advanced_DSA_Binary_Search_2;

class MedianOfTwoSortedArrays_Binary_Search {
    public static double findMedianSortedArrays(int[] A, int[] B) {

        // Time Complexity: O(log(min(n1,n2))), where n1 and n2 are the sizes of two given arrays.
        //Reason: We are applying binary search on the range [0, min(n1, n2)].
        //Space Complexity: O(1) as no extra space is used.

        // Get the lengths of both input arrays
        int n1 = A.length, n2 = B.length;

        // If the first array is longer, swap them to ensure n1 <= n2
        if (n1 > n2) return findMedianSortedArrays(B, A);

        // Calculate the total length of merged arrays and the length of the left half
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;

        // Apply binary search to find the median
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            // Calculate the values for the left and right partitions
            int l1 = (mid1 > 0) ? A[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? B[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? A[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? B[mid2] : Integer.MAX_VALUE;

            // Check if the partitions are in the correct order
            if (l1 <= r2 && l2 <= r1) {
                // Calculate the median based on the odd or even total length
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {
                // Adjust the search range
                high = mid1 - 1;
            } else {
                // Adjust the search range
                low = mid1 + 1;
            }
        }
        return 0; // Dummy statement (should never be reached)
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + findMedianSortedArrays(a, b));
    }
}