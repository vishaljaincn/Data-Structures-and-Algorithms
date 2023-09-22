package day30_Advanced_Contest1;

/*
given an array of length n containing only 0,1,2, you have to count the number of nice subarrays in it,
Nice subarray is defined as a  subarray containing atleast one occurrence of all the numbers 0,1,2
 */
public class Nice_SubArray {
    // This method takes an array A as input and returns the number of nice subarrays in it.
    public static long solve(int[] A) {
        int n = A.length; // Get the length of the input array A.
        int[] count = new int[3]; // Create an array to keep track of the count of 0s, 1s, and 2s.
        int left = 0; // Initialize the left pointer of the sliding window.
        long niceSubarrays = 0; // Initialize a variable to count the nice subarrays.

        // Loop through the elements of the input array A using a right pointer.
        for (int right = 0; right < n; right++) {
            count[A[right]]++; // Increment the count of the current element at right pointer.

            // Shrink the window from the left until it's not a nice subarray anymore.
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[A[left]]--; // Decrement the count of the element at the left pointer.
                left++; // Move the left pointer to the right.
            }

            // The subarrays ending at the current right index are nice, so add them to the count.
            niceSubarrays += left;
        }

        // Return the total count of nice subarrays.
        return niceSubarrays;
    }

    public static void main(String[] args) {
        // Test cases
        int a[] = {0, 1, 2, 1, 2, 0};
        System.out.println(solve(a)); // Output: 7

        int b[] = {0, 1, 0, 0, 2};
        System.out.println(solve(b)); // Output: 2

        int c[] = {0, 1, 1, 0};
        System.out.println(solve(c)); // Output: 0
    }
}
