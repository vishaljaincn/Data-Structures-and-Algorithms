package day8_Introductiion_To_Arrays_Interview_Problems;

/*
You're given a read-only array of N integers. Find out if any integer occurs more than N/3
times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Note: Read-only array means that the input array should not be modified in the process of solving the problem
 */
public class MajorityElementN_by_3 {
    public static int repeatedNumber(int[] A) {
        int n = A.length;
        // Edge case
        if (n == 1) {
            return A[0];
        }
        int count1 = 0;
        int count2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        //Modifying Moore's Voting Algorithm
        for (int i = 0; i < n; i++) {
            if (A[i] == candidate1) {
                count1++;
            } else if (A[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = A[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = A[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == candidate1) {
                count1++;
            } else if (A[i] == candidate2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            return candidate1;
        } else if (count2 > n / 3) {
            return candidate2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 2, 1, 1};
        System.out.println(repeatedNumber(A));
    }
}
