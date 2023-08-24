package day9_Introduction_To_Arrays_Contest_1;
/*
Given an array of integers A of size N, return the length of maximum size sub array
of A having only magic elements. Magic elements are numbers that divisible by 2 or 3
 */
public class MagicSubArrayLength {
    public static int findMagicSubArrayLength(int[] A) {
        int n = A.length;
        int maxLen = 0;
        int currentLen = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0 || A[i] % 3 == 0) {
                currentLen++;
            } else {
                currentLen = 0;
            }
            maxLen=Math.max(currentLen,maxLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] A = { 2, 3, 4, 6, 8, 9, 12, 14 };
        int maxLength = findMagicSubArrayLength(A);
        System.out.println("Length of maximum size magic subarray: " + maxLength);
    }
}
