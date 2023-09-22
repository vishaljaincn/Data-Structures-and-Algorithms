package day30_Advanced_Contest1;

/*
Given two arrays of size A and B of size N and M, representing 2 numbers, add those 2 numbers and return the result
 */
public class Add_Numbers_In_Two_Arrays {
    public static long solve(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        int digit1 = 1;
        long num1 = 0;
        for (int i = n - 1; i >= 0; i--) {
            num1 += A[i] * digit1;
            digit1 *= 10;
        }
        int digit2 = 1;
        long num2 = 0;
        for (int i = m - 1; i >= 0; i--) {
            num2 += B[i] * digit2;
            digit2 *= 10;
        }
        long result = num1 + num2;
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 1, 4};
        System.out.println(solve(a, b));
    }
}
