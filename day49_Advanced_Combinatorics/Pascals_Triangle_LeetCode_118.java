package day49_Advanced_Combinatorics;
/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
1 <= numRows <= 30
 */

import java.util.ArrayList;
import java.util.List;

//TC - O(N^2)
class Pascals_Triangle_LeetCode_118 {
    public static List<List<Integer>> generate(int numRows) {
        // Create a list to store the result
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            // Create a list to store the current row
            List<Integer> currentRow = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == i || j == 0) {
                    // The first and last elements in a row are always 1
                    currentRow.add(1);
                } else {
                    // Calculate nCr using the formula: nCr = (n - 1)C(r - 1) + (n - 1)Cr
                    int value = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    currentRow.add(value);
                }
            }

            // Add the current row to the result
            result.add(currentRow);
        }

        return result;
    }

    // Main method to test the generate function
    public static void main(String[] args) {
        int numRows = 6;
        List<List<Integer>> pascalsTriangle = generate(numRows);

        // Print Pascal's Triangle
        for (List<Integer> row : pascalsTriangle) {
            System.out.println(row);
        }
    }
}
