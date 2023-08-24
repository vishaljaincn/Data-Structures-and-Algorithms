package day10_Introduction_To_Bit_Manipulation_1;

/*
Given an array B of length A with elements 1 or 0. Find the number of sub arrays such that the bitwise OR of all the
elements present in the sub array is 1.
Note : The answer can be large. So, return type must be long.
 */
public class SubArrays_With_Bitwise_OR_1 {
    public static long solve(int A, int[] B) {
//        //not optimised approach
//        long count = 0;
//        // TC - O(N^2)
//        for (int i = 0; i < A; i++) {
//            int val = 0;
//            for (int j = i; j < A; j++) {
//                val = val | B[j];
//                if (val == 1) {
//                    count++;
//                }
//            }
//        }
//        return count;
//      //Optimized approach with TC - O(N)
        long zeros = 0;
        long count = 0;
        for (int i = 0; i < A; i++) {
            if (B[i] == 0) {
                zeros++;
            } else {
                count = count + zeros * (zeros + 1) / 2;
                zeros = 0; //Don't forget resetting the number of zeros to 0, when you encounter 1
            }
        }
        // what if there are zeros at the end of the loop, we don't encounter 1,
        // so handling that condition explicitly
        count = count + zeros * (zeros + 1) / 2;
        long finalAns = ((long) A * (A + 1) / 2) - count;
        return finalAns;
    }

    public static void main(String[] args) {
        int A1 = 3;
        int[] B1 = {1, 0, 1};
        System.out.println(solve(A1, B1));
        int A2 = 2;
        int[] B2 = {1, 0};
        System.out.println(solve(A2, B2));
    }
}