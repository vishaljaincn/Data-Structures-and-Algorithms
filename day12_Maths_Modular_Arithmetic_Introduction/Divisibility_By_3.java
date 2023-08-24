package day12_Maths_Modular_Arithmetic_Introduction;

/*
Given a number in the form of an array A of size N. Each of the digits of the number is represented by A[i].
Check if the number is divisible by 3.

Problem Constraints
1 <= N <= 105
0 <= A[i] <= 9
A[1] ≠ 0
 */
public class Divisibility_By_3 {
    public static int solve(int[] A) {
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + A[i];
        }
        if (sum % 3 == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 2, 3};
        int[] A2 = {1, 0, 0, 1, 2};
        System.out.println(solve(A1));
        System.out.println(solve(A2));
    }
}
