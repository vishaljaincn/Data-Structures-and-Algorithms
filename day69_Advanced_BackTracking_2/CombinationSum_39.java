package day69_Advanced_BackTracking_2;
/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
 */
/*
/**
 * Time Complexity: O(2^t * k)
 * - Explanation: 2 choices (pick or not pick) for each element, leading to 2^t recursive calls, with average combination length k.
 *
 * Why not O(2^n) but O(2^t) (where n is the array size)?
 * - Reasoning: Considers a constraint where an element can be picked t times, not necessarily equal to the array size.
 *
 * Space Complexity: O(x)
 * - Explanation: Maximum recursion depth or number of combinations (x).
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // List to store the final result of combinations
        List<List<Integer>> result = new ArrayList<>();

        // List to store the current combination being processed
        List<Integer> currentCombination = new ArrayList<>();

        // Start the backtracking process
        combinationSumUtil(candidates, target, 0, currentCombination, result);

        // Return the final result
        return result;
    }

    // Helper method for backtracking
    private static void combinationSumUtil(int[] candidates, int target, int start,
                                           List<Integer> currentCombination, List<List<Integer>> result) {
        // If the target is achieved, add the current combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Iterate through the candidates starting from the specified index
        for (int i = start; i < candidates.length; i++) {
            // Check if the current candidate is not greater than the remaining target
            if (candidates[i] <= target) {
                // Include the current candidate in the combination
                currentCombination.add(candidates[i]);

                // Recursively call with updated target and start index
                combinationSumUtil(candidates, target - candidates[i], i, currentCombination, result);

                // Backtrack: remove the last added element to try other combinations
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {


        // Example candidates array
        int[] candidates = {2, 3, 6, 7};

        // Example target
        int target = 7;

        // Find combinations
        List<List<Integer>> combinations = combinationSum(candidates, target);

        // Print the result
        System.out.println("Combinations for target " + target + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
