package day23_Intermediate_DSA_Contest_3;

import java.util.HashMap;
import java.util.Map;

/*
given  a number n, find the smallest number p, where multiplying all it's digits would result in n,
If no such p exists, return -1
 */
public class SmallestNumberWithProduct_Using_HashMap_O_LogN {
    public static int smallestNumberWithProduct_Using_HashMap_O_LogN(int n) {
        if (n < 10) {
            // If n is less than 10, return n + 10(single-digit numbers are already smallest)
            return n + 10;
        }

        // Create a HashMap to store the count of each digit from 9 to 2
        Map<Integer, Integer> digitCounts = new HashMap<>();

        // Iterate over potential factors from 9 to 2
        for (int i = 9; i >= 2; i--) {
            // Divide the number while it's divisible by the current factor (9 to 2)
            while (n % i == 0) {
                // Increment the count of the current factor in the digitCounts map
                digitCounts.put(i, digitCounts.getOrDefault(i, 0) + 1);
                // Divide the number by the current factor
                n /= i;
            }
        }

        // If n is still greater than 1, it has prime factors greater than 9
        if (n > 1) {
            return -1; // Return -1 to indicate failure
        }

        // Build the smallest number using the digit counts
        int smallestNum = 0;
        for (int digit = 2; digit <= 9; digit++) {
            if (digitCounts.containsKey(digit)) {
                int count = digitCounts.get(digit);
                // Add the current digit to the smallestNum count times
                for (int i = 0; i < count; i++) {
                    smallestNum = smallestNum * 10 + digit;
                }
            }
        }

        // Return the smallest number that can be formed using the factor digits
        return smallestNum;
    }

    public static void main(String[] args) {
        System.out.println(smallestNumberWithProduct_Using_HashMap_O_LogN(90));
    }
}