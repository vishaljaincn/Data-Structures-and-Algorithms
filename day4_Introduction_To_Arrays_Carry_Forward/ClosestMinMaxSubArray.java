package day4_Introduction_To_Arrays_Carry_Forward;

/*
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.

Problem Constraints
1 <= |A| <= 2000
Input Format
First and only argument is vector A
Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
Example Input
Input 1:
A = [1, 3, 2]
Input 2:
A = [2, 6, 1, 6, 9]
Example Output
Output 1:
 2
Output 2:
 3
Example Explanation
Explanation 1:
 Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
Explanation 2:
 Take the last 3 elements of the array.
 */
public class ClosestMinMaxSubArray {
    public static int solveUsingBruteForce(int[] A) {
        int n = A.length;
        int max = A[0];
        int min = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        if (max == min) {
            return 1;
        }
        // Brute Force
        int len, ans = n;
        for (int i = 0; i < n; i++) {
            if (A[i] == min) {
                for (int j = i + 1; j < n; j++) {
                    if (A[j] == max) {
                        len = j - i + 1;
                        if (len < ans) {
                            ans = len;
                        }
                        break;
                    }
                }
            } else if (A[i] == max) {
                for (int j = i + 1; j < n; j++) {
                    if (A[j] == min) {
                        len = j - i + 1;
                        if (len < ans) {
                            ans = len;
                        }
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static int solveUsingOptimizedApproach(int[] A) {
        int n = A.length;
        int max = A[0];
        int min = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
//        Edge case
        if (max == min) {
            return 1;
        }
        // optimized using carry forward approach
        int len, ans = n, maxi = -1, mini = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] == min) {
                mini = i;
                if (maxi != -1) {
                    len = maxi - mini + 1;
                    if (len < ans) {
                        ans = len;
                    }
                }
            } else if (A[i] == max) {
                maxi = i;
                if (mini != -1) {
                    len = mini - maxi + 1;
                    if (len < ans) {
                        ans = len;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 6, 9};
        System.out.println(solveUsingBruteForce(arr));
        System.out.println(solveUsingOptimizedApproach(arr));

    }
}
