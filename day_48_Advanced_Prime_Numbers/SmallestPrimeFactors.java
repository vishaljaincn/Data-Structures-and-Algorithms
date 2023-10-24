package day_48_Advanced_Prime_Numbers;

/*
 * given an integer N, find the smallest prime factor for all numbers from 2 to N in java
 */
//TC - O(N * log(log N) OR < O(N * log N)
public class SmallestPrimeFactors {
    public static int[] findSmallestPrimeFactors(int N) {
        int[] smallestPrimeFactor = new int[N + 1];

        // Initialize the smallest prime factor for each number as the number itself.
        for (int i = 2; i <= N; i++) {
            smallestPrimeFactor[i] = i;
        }

        // Update the smallest prime factors using the Sieve of Eratosthenes.
        for (int i = 2; i * i <= N; i++) {
            if (smallestPrimeFactor[i] == i) {
                for (int j = i * i; j <= N; j += i) {
                    if (smallestPrimeFactor[j] == j) {
                        smallestPrimeFactor[j] = i;
                    }
                }
            }
        }

        return smallestPrimeFactor;
    }

    public static void main(String[] args) {
        int N = 20; // Replace with your desired value of N
        int[] smallestPrimeFactors = findSmallestPrimeFactors(N);

        for (int i = 2; i <= N; i++) {
            System.out.println("Smallest prime factor of " + i + " is " + smallestPrimeFactors[i]);
        }
    }
}
