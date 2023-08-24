package day23_Intermediate_DSA_Contest_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
given  a number n, find the smallest number p, where multiplying all it's digits would result in n,
If no such p exists, return -1
 */
public class SmallestNumberWithProduct_Sorting_O_NLog_N {
    public static int smallestDigitMultiply_With_Sorting_O_NLog_N(int n) {
        // Write your code here.
        // If n is less than 10, return n + 10(single-digit numbers are already smallest)
        if (n < 10) {
            return n + 10;
        }

        // Create a list to store the factors of n
        List<Integer> factors = new ArrayList<>();

        // Iterate over potential factors from 9 to 2
        for (int i = 9; i >= 2; i--) {
            // Check if i is a factor of n
            while (n % i == 0) {
                // If i is a factor, add it to the list and update n
                factors.add(i);
                n = n / i;
            }
        }

        // If n is still greater than 1, it has prime factors greater than 9
        if (n > 1) {
            return -1;
        }

        // Sort the factors in ascending order
        Collections.sort(factors);

        // Calculate the smallest number using the sorted factors
        int smallestNum = 0;
        for (int factor : factors) {
            smallestNum = smallestNum * 10 + factor;
        }

        // Return the smallest number
        return smallestNum;
    }

    public static void main(String[] args) {
        System.out.println(smallestDigitMultiply_With_Sorting_O_NLog_N(90));
    }
}