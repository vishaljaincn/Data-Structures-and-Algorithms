package day49_Advanced_Combinatorics;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_Leetcode_119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            // Calculate each element in the current row from the end to the beginning
            result.add(0, 1); // Add 1 to the beginning of the list

            for (int j = 1; j < i; j++) {
                // Calculate the middle elements based on the previous row
                result.set(j, result.get(j) + result.get(j + 1));
            }
        }

        return result; // Return the rowIndex-th row of Pascal's Triangle
    }

    public static void main(String[] args) {
        // Test the getRow function
        int rowIndex = 3;
        List<Integer> row = getRow(rowIndex);
        System.out.println("Pascal's Triangle Row " + rowIndex + ": " + row);
    }
}
