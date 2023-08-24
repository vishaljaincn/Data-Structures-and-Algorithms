package day9_Introduction_To_Arrays_Contest_1;
/*
Given an array of distinct integers A of size N, find the length of longest strictly decreasing sub array
 */
public class FindLongestDecreasingSubArrayLength {
    public static int findLongestDecreasingSubArrayLength(int[] A) {
        int n = A.length;
        int currentLength = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] < A[i - 1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] A1 = {5, 4, 3, 2, 1};
        int[] A2 = {5, 4, 10, 2, 1}; // Example input array
        System.out.println("Length of the longest decreasing sub array: " + findLongestDecreasingSubArrayLength(A1));
        System.out.println("Length of the longest decreasing sub array: " + findLongestDecreasingSubArrayLength(A2));
    }
}
