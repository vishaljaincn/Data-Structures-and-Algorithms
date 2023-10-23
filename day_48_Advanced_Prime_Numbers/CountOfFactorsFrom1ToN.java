package day_48_Advanced_Prime_Numbers;
/*
 * given an integer N, find the count of factors of N for all numbers from 1 to N
 */
//TC - O(N * log(N))
public class CountOfFactorsFrom1ToN {
    public static int[] countFactors(int N) {
        int[] factorCount = new int[N + 1];

        // Loop through numbers from 1 to N
        for (int i = 1; i <= N; i++) {
            // Increment factor count for all multiples of i
            for (int j = i; j <= N; j += i) {
                factorCount[j]++;
            }
        }

        // Calculate the total count of factors for all numbers from 1 to N
        int totalCount = 0;
        for (int i = 0; i < factorCount.length; i++) {
            totalCount += factorCount[i];
        }

        // Print the total count of factors
        System.out.println("Total count of factors for numbers from 1 to " + N + ": " + totalCount);

        return factorCount;
    }

    public static void main(String[] args) {
        int N = 8;
        int[] factorCounts = countFactors(N);
        
        for (int i = 1; i <= N; i++) {
            System.out.println("Number " + i + " has " + factorCounts[i] + " factors.");
        }
    }
}
