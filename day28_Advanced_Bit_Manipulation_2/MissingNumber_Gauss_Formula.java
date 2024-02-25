package day28_Advanced_Bit_Manipulation_2;

/*
Given an array A containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.
 */
public class MissingNumber_Gauss_Formula {
    public int missingNumber(int[] A) {
        // Get the length of the input array 'A'
        int n = A.length;

        // Calculate the expected sum of numbers from 0 to n using the formula (n * (n + 1)) / 2
        int expectedSum = n * (n + 1) / 2;

        // Initialize a variable to store the actual sum of numbers in the 'A' array
        int actualSum = 0;

        // Iterate through the 'A' array to calculate the actual sum
        for (int i = 0; i < n; i++) {
            actualSum += A[i];
        }

        // Return the difference between the expected sum and the actual sum, which represents the missing number
        return expectedSum - actualSum;
    }

}
