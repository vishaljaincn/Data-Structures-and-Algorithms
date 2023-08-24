package day8_Introductiion_To_Arrays_Interview_Problems;

/*
Given an array of size N, find the majority element. The majority element is the element that
appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.
 */
public class MajorityElementN_by_2 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int majorityElement(final int[] A) {
        int n = A.length;
        int count = 0;
        int candidate = Integer.MIN_VALUE;
        // Moore's Voting Algorithm
        for (int i = 0; i < n; i++) {
            if (A[i] == candidate) {
                count++;
            } else if (count == 0) {
                candidate = A[i];
                count = 1;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == candidate) {
                count++;
            }
        }
        if (count > n / 2) {
            return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        System.out.println(majorityElement(A));
    }
}
