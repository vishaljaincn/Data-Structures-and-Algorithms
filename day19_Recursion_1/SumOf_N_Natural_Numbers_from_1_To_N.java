package day19_Recursion_1;

/*
 Given N, return the sum of all natural numbers till N [From 1 to N] using recursion
 */
public class SumOf_N_Natural_Numbers_from_1_To_N {
    // Recursive function to find the sum of natural numbers from 1 to N
    public static int sum(int N) {
        // Base case: Return 0 if N is equal to 0
        if (N == 0) {
            return 0;
        }
        // Main recursion logic:
        // Return the sum of natural numbers from 1 to (N-1) and add N to it
        return sum(N - 1) + N;
    }

    public static void main(String[] args) {
        System.out.println(sum(5)); // Print the sum of natural numbers from 1 to 5
    }
}
