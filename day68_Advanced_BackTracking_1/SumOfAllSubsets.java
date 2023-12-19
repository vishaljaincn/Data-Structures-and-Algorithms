package day68_Advanced_BackTracking_1;
/*
Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.

Example 1:
Input: N = 3, arr[] = {5,2,1}
Output: 0,1,2,3,5,6,7,8
Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are
[ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8

Example 2:
Input: N=3,arr[]= {3,1,2}
Output: 0,1,2,3,3,4,5,6
Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are
[ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6
 */
/*
Time Complexity: O(2^n)+O(2^n log(2^n)). Each index has two ways. You can either pick it up or not pick it.
So for n index time complexity for O(2^n) and for sorting it will take (2^n log(2^n)).

Space Complexity: O(N), Maximum Depth of the recursion tree(auxiliary space).
 */

import java.util.ArrayList;
import java.util.Collections;

class SumOfAllSubsets {

    // Main function to calculate subset sums
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // Initialize the list to store subset sums
        ArrayList<Integer> sumSubset = new ArrayList<>();

        // Start the recursive calculation from index 0 with initial sum 0
        subsetSumsHelper(0, 0, arr, N, sumSubset);

        // Sort the list of subset sums in increasing order
        Collections.sort(sumSubset);

        // Return the sorted list of subset sums
        return sumSubset;
    }

    // Helper function to calculate subset sums recursively
    static void subsetSumsHelper(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset) {
        // Base case: if the current index reaches the end of the array
        if (ind == N) {
            // Add the calculated sum to the list of subset sums
            sumSubset.add(sum);
            return;
        }

        // Pick the element at the current index and add it to the sum
        subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, N, sumSubset);

        // Do not pick the element at the current index and move to the next index
        subsetSumsHelper(ind + 1, sum, arr, N, sumSubset);
    }

    // Main method to test the subsetSums function
    public static void main(String args[]) {
        // Input array
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);

        // Calculate subset sums and store the result in 'ans'
        ArrayList<Integer> ans = subsetSums(arr, arr.size());

        // Sort the result for proper display
        Collections.sort(ans);

        // Print the calculated subset sums
        System.out.println("The sum of each subset is ");
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }
}
