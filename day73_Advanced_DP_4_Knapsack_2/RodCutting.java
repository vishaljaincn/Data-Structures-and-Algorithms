package day73_Advanced_DP_4_Knapsack_2;

/*
Time Complexity : O(N ^ 2)
Space Complexity : O(N ^ 2)

Where 'N' is the length of the rod.
        */

public class RodCutting {
    public static int cutRodUtil(int[] price, int maxLen, int n, int[][] cost) {

        // Base condition.
        if (n <= 0 || maxLen <= 0) {
            return 0;
        }

        // Checks whether problem is already calculated or not.
        if (cost[n][maxLen] != -1) {
            return cost[n][maxLen];
        }

		/*
		 	If the length of the rod to be cut is less than or equal
			to the size of rod of length 'max_len',
			then depending on profit, either it will accept the cut or discard it.
		*/
        if (n <= maxLen) {
            cost[n][maxLen] = Math.max(price[n - 1] + cutRodUtil(price, maxLen - n, n, cost),
                    cutRodUtil(price, maxLen, n - 1, cost));
        }

		/*
			If the length of the rod to be cut
			is greater than the size of rod of
			length 'max_len', cutting is not permitted.
		*/
        else {
            cost[n][maxLen] = cutRodUtil(price, maxLen, n - 1, cost);
        }

        return cost[n][maxLen];
    }

    public static int cutRod(int[] price, int n) {

        // Two state dp to store the sub-problems.
        int[][] cost = new int[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                cost[i][j] = -1;
            }
        }

        return cutRodUtil(price, n, n, cost);
    }
}
