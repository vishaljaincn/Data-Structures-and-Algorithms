package day39_Advanced_Contest_2;
/*

DON'T SEE THIS, BECAUSE I'VE NOT UNDERSTOOD THE APPROACH, BECAUSE IT'S A DYNAMIC PROGRAMMING PROBLEM

given an array of size N, denoting the height of towers labelled from 1 to N, you're initially standing at tower 1, the goal is to reach tower N, you can do 2 different kind of jumps
1)jump from ith tower to (i+1)th tower and it'll cost u B*Math.abs(A[i+1]-A[i]) dollars
2)jump from ith tower to (i+2)th tower and it'll cost u C*Math.abs(A[i+2]-A[i]) dollars
find and return the minimum possible cost incurred to reach the tower N
 */
public class Solution {
    public int solve(int[] A, int B, int C) {
        int N = A.length;

        int prevCost = 0; // Minimum cost to reach the first tower (tower 1).
        int currentCost = 0; // Minimum cost to reach the current tower.

        for (int i = 1; i < N; i++) {
            int nextCost1 = prevCost + B * Math.abs(A[i] - A[i - 1]);
            int nextCost2 = (i >= 2) ? prevCost + C * Math.abs(A[i] - A[i - 2]) : Integer.MAX_VALUE;

            currentCost = Math.min(nextCost1, nextCost2);
            prevCost = currentCost;
        }

        return currentCost; // Current cost contains the minimum cost to reach tower N.
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {1, 5, 6, 4, 5}; // Replace with your tower heights.
        int B = 2; // Replace with your B value.
        int C = 3; // Replace with your C value.

        int minCost = solution.solve(heights, B, C);
        System.out.println("Minimum cost to reach tower N: " + minCost);
    }
}
