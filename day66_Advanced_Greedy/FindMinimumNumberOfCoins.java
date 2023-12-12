package day66_Advanced_Greedy;

/*
Problem Statement: Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of
the denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued
coins/notes, what is the minimum number of coins and/or notes needed to make the change.

Examples:

Example 1:

Input: V = 70

Output: 2

Explaination: We need a 50 Rs note and a 20 Rs note.

Example 2:

Input: V = 121

Output: 3

Explaination: We need a 100 Rs note, a 20 Rs note and a 1 Rs coin.
 */
/*
Time Complexity:O(V)

Space Complexity:O(1)
 */

import java.util.ArrayList;

public class FindMinimumNumberOfCoins {
    public static void main(String[] args) {
        // Given value for which we need to make change
        int V = 49;

        // ArrayList to store the selected coins/notes
        ArrayList<Integer> ans = new ArrayList<>();

        // Denominations of Indian currency in descending order
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

        // Number of different denominations
        int n = coins.length;

        // Loop through the denominations in descending order
        for (int i = n - 1; i >= 0; i--) {
            // While the value to be changed is greater than or equal to the current denomination
            while (V >= coins[i]) {
                // Subtract the current denomination from the remaining value
                V -= coins[i];
                // Add the current denomination to the list of selected coins/notes
                ans.add(coins[i]);
            }
        }

        // Output the minimum number of coins/notes needed
        System.out.println("The minimum number of coins is " + ans.size());
        System.out.println("The coins are ");

        // Display the selected coins/notes
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(" " + ans.get(i));
        }
    }
}
