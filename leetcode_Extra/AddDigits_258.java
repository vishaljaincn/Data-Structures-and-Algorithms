package leetcode_Extra;

/*
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 */
// Time complexity: O(log n), where n is the value of the input number (number of digits).
// Space complexity: O(1), as the recursion depth is limited to the number of digits in the input.

public class AddDigits_258 {
    public int addDigits(int num) {
        // Base case: if the number is a single-digit, return the number
        if (num < 10) {
            return num;
        }

        // Calculate the sum of digits using recursion
        return addDigits(sumOfDigits(num));
    }

    // Helper method to calculate the sum of digits using recursion
    private int sumOfDigits(int n) {
        return (n > 0) ? n % 10 + sumOfDigits(n / 10) : 0;
    }
}
