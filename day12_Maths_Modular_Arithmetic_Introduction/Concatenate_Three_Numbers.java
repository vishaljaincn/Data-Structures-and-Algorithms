package day12_Maths_Modular_Arithmetic_Introduction;

/*
Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.
Return the minimum result obtained.

Problem Constraints
10 <= A, B, C <= 99

Input Format
The first argument of input contains an integer, A.
The second argument of input contains an integer, B.
The third argument of input contains an integer, C.
Output Format
Return an integer representing the answer.

Example Input
Input 1:
 A = 10
 B = 20
 C = 30
Input 2:
 A = 55
 B = 43
 C = 47
Example Output
Output 1:
 102030
Output 2:
 434755
Example Explanation
Explanation 1:

 10 + 20 + 30 = 102030
Explanation 2:

 43 + 47 + 55 = 434755
 */
public class Concatenate_Three_Numbers {
    public static int solve(int A, int B, int C) {
        int minValue = Math.min(Math.min(A, B), C);
        int maxValue = Math.max(Math.max(A, B), C);
        int middleValue = A + B + C - minValue - maxValue;
        return minValue * 10000 + middleValue * 100 + maxValue;

//      Both works fine
/*
        int minValue = 0;
        int maxValue = 0;
        int middleValue = 0;
        if (A <= B && A <= C) {
            minValue = A;
        } else if (B <= A && B <= C) {
            minValue = B;
        } else {
            minValue = C;
        }
        if (A >= B && A >= C) {
            maxValue = A;
        } else if (B >= A && B >= C) {
            maxValue = B;
        } else {
            maxValue = C;
        }
        middleValue = A + B + C - minValue - maxValue;
        return (minValue * 10000) + (middleValue * 100) + maxValue;
*/
    }

    public static void main(String[] args) {
        System.out.println(solve(10, 30, 20));
        System.out.println(solve(55, 43, 47));
    }
}
