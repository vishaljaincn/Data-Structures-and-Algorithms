package day30_Advanced_Contest1;
/*
Given an array nums, return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length
such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 */
class Check_If_Array_Is_Sorted_And_Rotated {
    // Function to check if an array can be rotated at most one element to make it non-decreasing.
    public static boolean check(int[] A) {
        int violations = 0; // Initialize a counter to keep track of how many times elements are out of order.
        int n = A.length; // Get the length of the input array.

        // Iterate through the elements of the array.
        for (int i = 0; i < n; i++) {
            // Compare the current element with the next element (cyclically).
            if (A[i] > A[(i + 1) % n]) {
                violations++; // If the current element is greater than the next, increment the violations counter.
            }

            // If the violations counter exceeds 1, return false (indicating it can't be made non-decreasing).
            if (violations > 1) {
                return false;
            }
        }

        // If we reach this point, it means the array can be made non-decreasing with at most one rotation.
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 1};
        System.out.println("Result for arr1: " + check(arr1)); // Should print false

        int[] arr2 = {4, 2, 3};
        System.out.println("Result for arr2: " + check(arr2)); // Should print true
    }
}
