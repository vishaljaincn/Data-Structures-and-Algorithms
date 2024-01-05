package day68_Advanced_BackTracking_1;

/*
Time Complexity: O(2^n) Each index has two ways. You can either pick it up or not pick it.
So for n index time complexity for O(2^n)

Space Complexity: O(N), Maximum Depth of the recursion tree(auxiliary space).
 */

import java.util.ArrayList;

class CountSubsetsWithSumK {
    // Counter to store the count of subsets with the target sum
    static int count = 0;

    // Helper function to calculate subset sums and count subsets with sum equal to k
    static void subsetSumsHelper(int ind, int sum, ArrayList<Integer> arr, int N, int k) {
        // Base case: if the current index reaches the end of the array
        if (ind == N) {
            // Check if the current sum equals the target sum
            if (sum == k) {
                // Increment the counter if the condition is met
                count++;
            }
            return;
        }

        // Pick the element at the current index and add it to the sum
        subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, N, k);

        // Do not pick the element at the current index and move to the next index
        subsetSumsHelper(ind + 1, sum, arr, N, k);
    }

    // Main function to calculate count of subsets with sum equal to k
    static int countSubsetsWithSumK(ArrayList<Integer> arr, int N, int k) {
        // Start the recursive calculation from index 0 with initial sum 0
        subsetSumsHelper(0, 0, arr, N, k);

        // Return the count of subsets with sum equal to k
        return count;
    }

    // Main method to test the countSubsetsWithSumK function
    public static void main(String args[]) {
        // Input array
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);

        // Target sum
        int k = 3;

        // Calculate count of subsets with sum equal to k
        int result = countSubsetsWithSumK(arr, arr.size(), k);

        // Print the result
        System.out.println("The count of subsets with sum " + k + " is: " + result);
    }
}
