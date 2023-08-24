package day7_Introduction_To_Arrays_Sliding_Window_And_Spiral_Order_Matix;

/*
 * Given an array of integers A and an integer B, find and return the minimum number of swaps
 * required to bring all the numbers less than or equal to B together.
 *
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 */
public class MinimumSwaps {
    public static int solve(int[] A, int B) {
        int n = A.length;

        // Counting all the numbers <= B
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] <= B) {
                count++;
            }
        }

        // Edge cases
        if (count == 0 || count == 1) {
            // If there are no elements less than or equal to B, or only one such element,
            // no swaps are needed, so the result is 0.
            return 0;
        }

        // Checking the first window
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (A[i] > B) {
                bad++;
            }
        }

        // Sliding window approach
        int ans = bad, start = 1, end = count;
        while (end < n) {
            if (A[start - 1] > B) {
                bad--;
            }
            if (A[end] > B) {
                bad++;
            }
            if (bad < ans) {
                ans = bad;
            }
            start++;
            end++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 12, 10, 3, 14, 10, 5};
        System.out.println(solve(arr, 8)); // Output: 2
    }
}
