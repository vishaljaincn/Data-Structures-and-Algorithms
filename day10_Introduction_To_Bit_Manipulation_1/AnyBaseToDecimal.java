package day10_Introduction_To_Bit_Manipulation_1;

/*
You are given a number A. You are also given a base B. A is a number on base B.
You are required to convert the number A into its corresponding value in decimal number system.

Problem Constraints
0 <= A <= 109
2 <= B <= 9

Input Format
First argument A is an integer.
Second argument B is an integer.

Output Format
Return an integer.

Example Input
Input 1:
A = 1010
B = 2
Input 2:
A = 22
B = 3

Example Output
Output 1:
10
Output 2:
8
 */
public class AnyBaseToDecimal {
    public static int solve(int A, int B) {
        int result = 0;
        int power = 0;

        while (A > 0) {
            int remainder = A % 10;
            result = result + remainder * (int) Math.pow(B, power);
            A = A / 10;
            power++;
        }

        return result;
    }

    public static void main(String[] args) {
        int A1 = 1010;
        int B1 = 2;
        System.out.println(solve(A1,B1));
        int A2 = 22;
        int B2 = 3;
        System.out.println(solve(A2,B2));
    }
}
