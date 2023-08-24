package day10_Introduction_To_Bit_Manipulation_1;

/*
Given a decimal number A and a base B, convert it into its equivalent number in base B.

Problem Constraints
0 <= A <= 512
2 <= B <= 10

Input Format
The first argument will be decimal number A.
The second argument will be base B.

Output Format
Return the conversion of A in base B.

Example Input
Input 1:
A = 4
B = 3
Input 2:
A = 4
B = 2

Example Output
Output 1:
11
Output 2:
100

Example Explanation
Explanation 1:
Decimal number 4 in base 3 is 11.
Explanation 2:
Decimal number 4 in base 2 is 100.
 */
public class DecimalToAnyBase {
    public static int decimalToAnyBase(int A, int B) {
        int position = 1;
        int finalAns = 0;
        while (A > 0) {
            int remainder = A % B;
            finalAns = finalAns + remainder * position;
            position = position * 10;
            A = A / B;
        }
        return finalAns;
    }

    public static void main(String[] args) {
        int A1 = 4;
        int B1 = 3;
        System.out.println(decimalToAnyBase(A1, B1));
        int A2 = 4;
        int B2 = 2;
        System.out.println(decimalToAnyBase(A2, B2));
    }
}
