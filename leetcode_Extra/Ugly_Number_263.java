package leetcode_Extra;
/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return true if n is an ugly number.

Example 1:
Input: n = 6
Output: true
Explanation: 6 = 2 × 3

Example 2:
Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

Example 3:
Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.
 */

// Time complexity: O(log num), where num is the value of the input integer.
// Space complexity: O(1), no additional data structures are used.
public class Ugly_Number_263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false; // Negative numbers and zero are not Ugly Numbers
        }

        // Divide num by 2, 3, and 5 as long as it is divisible
        for (int i = 2; i <= 5; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }

        return num == 1; // If num becomes 1, it is an Ugly Number
    }
}
