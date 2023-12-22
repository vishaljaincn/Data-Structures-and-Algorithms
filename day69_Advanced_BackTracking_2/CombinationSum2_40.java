package day69_Advanced_BackTracking_2;
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
 */
/*
 * Time Complexity: O(2^n * k)
 * - Reasoning: If all elements in the array are unique, the number of subsequences is O(2^n).
 *   We add the data structure to our answer when reaching the base case, which takes "k" on average for space.
 *
 * Space Complexity: O(n)
 * - Reasoning: Maximum depth of the recursion tree
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort to handle duplicates and optimize the solution
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        // Start the backtracking process
        combinationSum2Util(candidates, target, 0, currentCombination, result);
        return result;
    }

    private static void combinationSum2Util(int[] candidates, int target, int start,
                                            List<Integer> currentCombination, List<List<Integer>> result) {
        // If the target is achieved, add the current combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Iterate through the candidates starting from the specified index
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] <= target) {
                // Include the current candidate in the combination
                currentCombination.add(candidates[i]);

                // Recursively call with updated target and start index
                combinationSum2Util(candidates, target - candidates[i], i + 1, currentCombination, result);

                // Backtrack: remove the last added element to try other combinations
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        // Example candidates array with duplicates
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};

        // Example target
        int target = 8;

        // Find combinations
        List<List<Integer>> combinations = combinationSum2(candidates, target);

        // Print the result
        System.out.println("Combinations for target " + target + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
