package day4_Introduction_To_Arrays_Carry_Forward;

/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.
 */
public class BestTimeToBuyAndSellStocks {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int maxProfit(final int[] A) {
        int leastSoFar = Integer.MAX_VALUE; // lsf: Least So Far
        int overallProfit = 0; // op: Overall Profit
        int profitIfSoldToday = 0; // pist: Profit If Sold Today

        for (int i = 0; i < A.length; i++) {
            if (A[i] < leastSoFar) {
                leastSoFar = A[i];
            }
            profitIfSoldToday = A[i] - leastSoFar;
            if (overallProfit < profitIfSoldToday) {
                overallProfit = profitIfSoldToday;
            }
        }
        return overallProfit;
    }

    public static void main(String[] args) {
        int arr[]={1, 4, 5, 2, 4};
        System.out.println(maxProfit(arr));

    }
}
