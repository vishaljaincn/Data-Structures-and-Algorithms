package day42_Advanced_Hashing_1;

import java.util.HashSet;

/*
given and Integer array A, find the length of the longest consecutive chain of Elements(X,X+1,X+2,X+3........)
 */
public class Longest_Consecutive_Chain_Of_Elements_Using_HashSet_O_N {
    public static int solve(int A[]) {
        int n = A.length;
        int ans = 1;  // Initialize the result to 1 since a single element is always a consecutive chain of length 1.
        HashSet<Integer> hs = new HashSet<>();  // Create a HashSet to store the elements.

        // Add all elements from the array to the HashSet for quick lookup.
        for (int i = 0; i < n; i++) {
            hs.add(A[i]);
        }

        // Iterate through the HashSet to find the start of consecutive chains.
        for (int i : hs) {
            if (!hs.contains(i - 1)) {  // If the current element is the possible start of a consecutive chain.
                int cnt = 1;  // Initialize a counter for the current chain.
                int y = i + 1;  // Start checking for consecutive elements.

                // Count the consecutive elements in the chain.
                while (hs.contains(y)) {
                    cnt++;
                    y++;
                }

                // Update the maximum chain length found so far.
                ans = Math.max(ans, cnt);
            }
        }

        return ans;  // Return the maximum consecutive chain length.
    }

    public static void main(String[] args) {
        int A[] = {100, 4, 3, 6, 8, 10, 20, 11, 5, 101};
        System.out.println(solve(A)); // Print the result
    }
}
