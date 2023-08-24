package day11_Introduction_To_Bit_Manipulation_2;

/*
Given an integer A, find and return the Ath magic number.

A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.

First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

Problem Constraints
1 <= A <= 5000
 */
public class Find_Nth_Magic_Number {
    public static int solve(int A) {
        int finalAns = 0, power = 5;
        // If the ith bit(1 based indexing) is set we will add 5i to our answer.
        // Time Complexity:- O(log(A))
        while (A > 0) {
            int remainder = A % 2;
            finalAns = finalAns + remainder * power;
            power = power * 5;
            A = A / 2;
        }
        return finalAns;
    }

    public static void main(String[] args) {
        System.out.println(solve(3));
        System.out.println(solve(10));
    }
}
