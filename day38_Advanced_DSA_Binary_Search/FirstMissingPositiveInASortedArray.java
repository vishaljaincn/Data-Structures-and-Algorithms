package day38_Advanced_DSA_Binary_Search;

// Time complexity: O(log n), Space complexity: O(1) for binary search in sorted array to find the first missing positive.

public class FirstMissingPositiveInASortedArray {

    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;
        int missingPositive = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If the current element is in its correct position, search on the right side
            if (arr[mid] == mid + 1) {
                low = mid + 1;
            }
            // If the current element is not in its correct position, potential missing positive found
            else {
                missingPositive = mid;
                high = mid - 1;
            }
        }

        // Index 'missingPositive' corresponds to the first incorrect data
        return missingPositive + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        System.out.println("First missing positive: " + findFirstMissingPositive(arr1)); // Output: 3

        int[] arr2 = {1, 2, 3, 4, 6, 9, 10};
        System.out.println("First missing positive: " + findFirstMissingPositive(arr2)); // Output: 5
    }
}
