package day15_Intermediate_DSA_Contest2;

/*
Given an array A of Integers and the task is to find the product of numbers which are greater than their adjacent
right number. The number can be very large which might not fit in the integer range. so return the number by taking
modulo with 10^9+7

Note - Adjacent Right number is the number that is just next to the current number in the array

Constraints
1<=N<=10^5
1<=A[i]<=10^9
 */
public class Adjacent_Right_Number {
    public static int solve(int[] A) {
        int n = A.length;

        // If the array has less than 2 elements, return 0 as there are no adjacent element to compare
        if (n < 2) {
            return 0;
        }

        int mod = (int) Math.pow(10, 9) + 7;
        long product = 1L;

        // Calculate the product of numbers that are greater than their adjacent right number
        for (int i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1]) {
                product = (product * A[i]) % mod;
            }
        }

        // If the product is still 1 after all the iterations, then no number satisfies the condition, return 0
        if (product == 1L) {
            return 0;
        }

        // Return the product modulo 10^9+7 as an integer
        return (int) product % mod;
    }

    public static void main(String[] args) {
        int[] A1 = {5};
        int[] A2 = {7, 7, 4, 5, 3};
        int[] A3 = {2, 3, 4, 5, 6};
        int[] A4 = {4, 3};
        System.out.println(solve(A1));
        System.out.println(solve(A2));
        System.out.println(solve(A3));
        System.out.println(solve(A4));

    }

}
