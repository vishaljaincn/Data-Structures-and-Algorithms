package day28_Bit_Manipulation_2;
/*
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.
 */
public class MissingNumber_Bit_Manipulation {
    class Solution {
        public int missingNumber(int[] A) {
            int n = A.length;
            // Initialize the result variable to the length of the input array,
            // as it is a potential missing number.
            int res = n;

            // Iterate through the elements of the input array.
            for (int i = 0; i < n; i++) {
                // XOR the current index 'i' with the result.
                // This helps in finding the missing number by canceling out
                // elements that are present in both 'i' and 'A[i]'.
                res ^= i;

                // XOR the current element 'A[i]' with the result.
                // This also helps in canceling out elements that are present
                // in both 'i' and 'A[i]'.
                res ^= A[i];
            }

            // After the loop, 'res' will contain the missing number.
            return res;
        }
    }

}
