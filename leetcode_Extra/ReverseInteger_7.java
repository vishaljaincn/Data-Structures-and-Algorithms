package leetcode_Extra;
/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 */

//Time Complexity: O(log10(x))
//Space Complexity: O(1)
class ReverseInteger_7 {
    public int reverse(int x) {
        long finalNum = 0; // Initialize a variable to store the reversed number, starting with 0
        while (x != 0) { // Loop until x becomes 0
            int lastDig = x % 10; // Extract the last digit of x
            finalNum = finalNum * 10 + lastDig; // Append the last digit to the reversed number
            x = x / 10; // Remove the last digit from x
        }

        // Check for overflow before casting the reversed number to an integer
        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return 0; // Return 0 if overflow occurs
        }

        // Handle negative numbers
        if (x < 0) {
            return (int) (-1 * finalNum); // Return the negative reversed number
        }

        // Return the reversed number
        return (int) finalNum;
    }
}
