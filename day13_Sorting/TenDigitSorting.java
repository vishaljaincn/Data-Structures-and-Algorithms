package day13_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.

If a number has no tens digit, we can assume value to be 0.
If 2 numbers have same tens digit, in that case number with max value will come first
Solution should be based on comparator.
 */
public class TenDigitSorting {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int tensA = tensPlace(a);
                int tensB = tensPlace(b);
                if (tensA != tensB) {
                    return Integer.compare(tensA, tensB);
                } else {
                    return Integer.compare(b, a);
                }
            }

            public int tensPlace(int num) {
                // Get the tens place digit of the number
                return (num / 10) % 10;
            }
        });
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(24);
        al.add(22);
        al.add(19);
        System.out.println(solve(al));
    }
}
