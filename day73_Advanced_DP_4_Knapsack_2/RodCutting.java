package day73_Advanced_DP_4_Knapsack_2;
/*
Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it.
Determine the maximum cost obtained by cutting the rod and selling its pieces.

Note:
1. The sizes will range from 1 to ‘N’ and will be integers.

2. The sum of the pieces cut should be equal to ‘N’.

3. Consider 1-based indexing.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 50
1 <= N <= 100
1 <= A[i] <= 100

Where ‘T’ is the total number of test cases, ‘N’ denotes the length of the rod, and A[i] is the cost of sub-length.

Time limit: 1 sec.
Sample Input 1:
2
5
2 5 7 8 10
8
3 5 8 9 10 17 17 20
Sample Output 1:
12
24
Explanation of sample input 1:
Test case 1:

All possible partitions are:
1,1,1,1,1           max_cost=(2+2+2+2+2)=10
1,1,1,2             max_cost=(2+2+2+5)=11
1,1,3               max_cost=(2+2+7)=11
1,4                 max_cost=(2+8)=10
5                   max_cost=(10)=10
2,3                 max_cost=(5+7)=12
1,2,2               max _cost=(1+5+5)=12

Clearly, if we cut the rod into lengths 1,2,2, or 2,3, we get the maximum cost which is 12.


Test case 2:

Possible partitions are:
1,1,1,1,1,1,1,1         max_cost=(3+3+3+3+3+3+3+3)=24
1,1,1,1,1,1,2           max_cost=(3+3+3+3+3+3+5)=23
1,1,1,1,2,2             max_cost=(3+3+3+3+5+5)=22
and so on….

If we cut the rod into 8 pieces of length 1, for each piece 3 adds up to the cost. Hence for 8 pieces, we get 8*3 = 24.
Sample Input 2:
1
6
3 5 6 7 10 12
Sample Output 2:
18
 */
/*
    Rod Cutting Dynamic Programming Solution

    Time Complexity: O(N^2)
    Space Complexity: O(N^2)

    Where 'N' is the length of the rod.
*/

public class RodCutting {

    public static int cutRodUtil(int[] price, int maxLen, int n, int[][] cost) {
        // Base condition: if the length or maximum length is zero, return zero profit.
        if (n <= 0 || maxLen <= 0) {
            return 0;
        }

        // Check if the subproblem has already been solved, return the stored result.
        if (cost[n][maxLen] != -1) {
            return cost[n][maxLen];
        }

        // If the length of the rod is less than or equal to the maximum length,
        // choose the maximum between including or excluding the current cut.
        if (n <= maxLen) {
            cost[n][maxLen] = Math.max(price[n - 1] + cutRodUtil(price, maxLen - n, n, cost),
                    cutRodUtil(price, maxLen, n - 1, cost));
        } else {
            // If the length of the rod is greater than the maximum length, cutting is not permitted.
            cost[n][maxLen] = cutRodUtil(price, maxLen, n - 1, cost);
        }

        // Return the maximum profit for the current subproblem.
        return cost[n][maxLen];
    }

    /*
        Main function to calculate the maximum profit from rod cutting.
    */
    public static int cutRod(int[] price, int n) {
        // Two-dimensional array to store the results of subproblems.
        int[][] cost = new int[n + 1][n + 1];

        // Initialize the cost array with -1 to indicate that subproblems are not solved yet.
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                cost[i][j] = -1;
            }
        }

        // Call the utility function to get the maximum profit.
        return cutRodUtil(price, n, n, cost);
    }
}
