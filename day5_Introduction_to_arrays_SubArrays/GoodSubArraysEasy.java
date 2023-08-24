package day5_Introduction_to_arrays_SubArrays;

/*
Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.
 */
public class GoodSubArraysEasy {
    public static int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + A[j];
                if ((j - i + 1) % 2 == 0 && sum < B) {
                    count++;
                } else if ((j - i + 1) % 2 == 1 && sum > B) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={1, 2, 3, 4, 5};
        System.out.println(solve(arr,4));
    }
}
