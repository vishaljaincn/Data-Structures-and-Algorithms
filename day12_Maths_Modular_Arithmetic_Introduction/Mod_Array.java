package day12_Maths_Modular_Arithmetic_Introduction;

/*
You are given a large number in the form of a array A of size N where each element denotes a digit of the number.
You are also given a number B. You have to find out the value of A % B and return it.

Problem Constraints
1 <= N <= 105
0 <= Ai <= 9
1 <= B <= 109
 */
public class Mod_Array {
    public static int solve(int[] A, int B) {
        // Both sum and t should be of type long
        long sum = 0;
        long t = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            sum = (sum + A[i] * t) % B;
            t = (t * 10) % B;
        }
        return (int) sum % B;
    }

    public static void main(String[] args) {
        int arr[]={4, 3, 5, 3, 5, 3, 2, 1};
        System.out.println(solve(arr,47));
    }
}
