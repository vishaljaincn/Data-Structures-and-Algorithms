package day11_Introduction_To_Bit_Manipulation_2;

/*
Problem Description
Reverse the bits of an 32 bit unsigned integer A.

Problem Constraints
0 <= A <= 232

Input Format
First and only argument of input contains an integer A.

Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.

Example Input
Input 1:
 0
Input 2:
 3
Example Output
Output 1:
 0
Output 2:
 3221225472

Example Explanation
Explanation 1:
        00000000000000000000000000000000
=>      00000000000000000000000000000000
Explanation 2:
        00000000000000000000000000000011
=>      11000000000000000000000000000000
 */
public class Reverse_Bits {
    public static long reverse(long A) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            // The reason for this operation is to make space for the next bit to be set in the result.
            result = result << 1;
            // Checking if the current LSB(right most bit) of A is set or not
            if ((A & 1) == 1) {
                // sets the current LSB(right most bit) of result
                result = result | 1;
            }
            // removing current LSB(right most bit) of A
            A = A >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(8));
    }
}
