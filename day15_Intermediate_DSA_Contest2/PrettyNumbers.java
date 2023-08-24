package day15_Intermediate_DSA_Contest2;
/*
Given an array of N Integers , return the pretty integers in the array same relative ordering as the original array
Pretty numbers are the ones which have at least 2 numbers less than themselves.

Constraints
1<=N<=10^5
1<=A[i]<=10^5
 */

import java.util.ArrayList;

public class PrettyNumbers {

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int firstMinimum = Integer.MAX_VALUE;
        // Find First Minimum
        for (int i = 0; i < n; i++) {
            if (A.get(i) < firstMinimum) {
                firstMinimum = A.get(i);
            }
        }

        int secondMinimum = Integer.MAX_VALUE;
        // Find Second Minimum
        for (int i = 0; i < n; i++) {
            if (A.get(i) < secondMinimum && A.get(i) > firstMinimum) {
                secondMinimum = A.get(i);
            }
        }

        int firstCount = 0;
        // Count occurrences of the first minimum
        for (int i = 0; i < n; i++) {
            if (A.get(i) == firstMinimum) {
                firstCount++;
            }
        }

        ArrayList<Integer> al = new ArrayList<Integer>();

        // Collect Pretty Numbers
        for (int i = 0; i < n; i++) {
            int num = A.get(i);
            // Check if the number is greater than both minimums or greater than the first minimum with at least two occurrences of the first minimum
            if ((num > firstMinimum && num > secondMinimum) || (num > firstMinimum && firstCount >= 2)) {
                al.add(num);
            }
        }

        return al;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(9);
        al.add(2);
        al.add(4);
        System.out.println(solve(al));
    }
}
