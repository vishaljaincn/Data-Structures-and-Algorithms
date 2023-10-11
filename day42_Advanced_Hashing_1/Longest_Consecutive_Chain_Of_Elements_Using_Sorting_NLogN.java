package day42_Advanced_Hashing_1;

import java.util.Arrays;

/*
given and Integer array A, find the length of the longest consecutive chain of Elements(X,X+1,X+2,X+3........)
 */
public class Longest_Consecutive_Chain_Of_Elements_Using_Sorting_NLogN {
    // Method to find the length of the longest consecutive chain of elements
    public static int solve(int A[]) {
        Arrays.sort(A); // Sort the input array
        int ans = 1, cnt = 1, n = A.length;
        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1] + 1) {
                cnt++; // Increment chain length if consecutive
            } else {
                ans = Math.max(ans, cnt); // Update answer if a longer chain is found
                cnt = 1; // Reset chain length
            }
        }
        return ans; // Return the maximum chain length
    }

    public static void main(String[] args) {
        int A[] = {100, 4, 3, 6, 8, 10, 20, 11, 5, 101};
        System.out.println(solve(A)); // Print the result
    }
}
