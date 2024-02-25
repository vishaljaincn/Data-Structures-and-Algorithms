package leetcode_Extra;
/*
Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:
Input: n = 2
Output: false

Constraints:
1 <= n <= 231 - 1
 */

import java.util.HashSet;
import java.util.Set;

//Time Complexity - O(log N) or O(1), Even for Int_Max ,the sum of squares of all the digits is not more than 1000
//Space Complexity - O(log N) or O(1)
class HappyNumber_202 {
    public boolean isHappy(int n) {
        // Set to detect cycles
        Set<Integer> seen = new HashSet<>();

        // Continue the process until a happy number is found or a cycle is detected
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = helper(n);
        }

        // If the loop exited because n is 1, it's a happy number
        return n == 1;
    }

    // Helper function to calculate the sum of squares of digits
    private int helper(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
