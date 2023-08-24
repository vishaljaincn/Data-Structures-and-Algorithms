package day15_Intermediate_DSA_Contest2;

import java.util.Arrays;

/*
given an array of size n, return the highest product possible by multiplying 3 numbers from the array

Constraints:
-10^9 <= A[i] <= 0^9
 */
public class HighestProductOfThree {
    public static int highestProductOfThree(int[] A) {
        Arrays.sort(A); // Sort the array in ascending order

        int n = A.length;

        // Calculate two possible products
        int product1 = A[n - 1] * A[n - 2] * A[n - 3]; // Product of the three largest numbers
        int product2 = A[0] * A[1] * A[n - 1];         // Product of two smallest and one largest number

        // Return the maximum of the two products
        return Math.max(product1, product2);
    }

    public static void main(String[] args) {
        int[] A = {-10, -10, 1, 3, 2};
        int result = highestProductOfThree(A);
        System.out.println(result); // Output will be 300 (since -10 * -10 * 3 = 300)
    }
}
