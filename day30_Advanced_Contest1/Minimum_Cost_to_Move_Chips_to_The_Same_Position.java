package day30_Advanced_Contest1;

/*
We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step, we can change the position of the ith chip from
position[i] to:

position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.
 */
public class Minimum_Cost_to_Move_Chips_to_The_Same_Position {
    public static int minCostToMoveChips(int[] A) {
        int n = A.length; // Get the total number of chips
        int even_cnt = 0; // Initialize a count for chips at even positions
        int odd_cnt = 0; // Initialize a count for chips at odd positions

        // Loop through the array of chips
        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0) {
                even_cnt++; // If the chip is at an even position, increment the even count
            } else {
                odd_cnt++; // If the chip is at an odd position, increment the odd count
            }
        }

        // Return the minimum cost, which is the smaller of odd count and even count
        return Math.min(odd_cnt, even_cnt);
    }
}