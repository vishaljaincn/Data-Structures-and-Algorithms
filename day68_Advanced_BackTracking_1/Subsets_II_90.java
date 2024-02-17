package day68_Advanced_BackTracking_1;

import java.util.ArrayList;
import java.util.Collections;

/*
Given an integer array nums that may contain duplicates, return all possible
subsets(the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

 */
// Time complexity: O(2^n), Space complexity: O(n) for backtracking approach in LeetCode problem 90.

public class Subsets_II_90 {

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> tempSet = new ArrayList<>();

        Collections.sort(nums);

        backtrack(resultList, tempSet, nums, 0);

        return resultList;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> resultSets, ArrayList<Integer> tempSet, ArrayList<Integer> nums, int start) {
        resultSets.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.size(); i++) {
            if (i > start && nums.get(i) == nums.get(i - 1)) continue;

            tempSet.add(nums.get(i));
            backtrack(resultSets, tempSet, nums, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public static void main(String[] args) {

        // Example input array with duplicates
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        nums.add(3);

        // Generate subsets with duplicates using the solution class
        ArrayList<ArrayList<Integer>> result = subsetsWithDup(nums);

        // Display the result sets
        System.out.println("Subsets with Duplicates:");
        for (ArrayList<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
