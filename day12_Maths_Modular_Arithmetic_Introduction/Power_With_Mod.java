package day12_Maths_Modular_Arithmetic_Introduction;

/*
You are given A, B and C .
Calculate the value of (A ^ B) % C

Problem Constraints
1 <= A <= 109
0 <= B <= 105
1 <= C <= 109

Input Format
Given three integers A, B and C.

Output Format
Return an integer.

Example Input
Input 1:
A = 2
B = 3
C = 3
Input 2:
A = 5
B = 2
C = 4

Example Output
Output 1:
2
Output 2:
1

Example Explanation
For Input 1:
(2 ^ 3) % 3 = 8 % 3 = 2
For Input 2:
(5 ^ 2) % 4 = 25 % 4 = 1
 */
public class Power_With_Mod {
    public static int solve(int A, int B, int C) {
        // edge case
        if (B == 0) {
            return 1;
        }
        // ans variable must be of long type
        long ans = 1;
        for (int i = 0; i < B; i++) {
            ans = (ans * A) % C;
        }
        return (int) ans % C;
    }

    public static void main(String[] args) {
        System.out.println(solve(2,3,3));
    }
}
