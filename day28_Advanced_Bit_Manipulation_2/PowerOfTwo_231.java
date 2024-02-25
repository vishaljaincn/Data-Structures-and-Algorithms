package day28_Advanced_Bit_Manipulation_2;

/*
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
 */

// Time complexity: O(1), as the operation involves constant bitwise operations.
// Space complexity: O(1), no additional data structures are used.

public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        // Check if n is a positive integer and has only one set bit (power of two)
        // Using bitwise AND operation with (n - 1) ensures that there is only one '1' bit in the binary representation of n
        // For example, 8 (binary: 1000) & 7 (binary: 0111) results in 0
        // This means that 8 is a power of two
        return n > 0 && (n & (n - 1)) == 0;
    }
}
