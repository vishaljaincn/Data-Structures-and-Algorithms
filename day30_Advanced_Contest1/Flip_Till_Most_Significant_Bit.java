package day30_Advanced_Contest1;

/*
 Given an Integer A, the task is to find the complement (flip all the bits - 0's to 1's and 1's to 0's) of A
 only until the most significant bit
 */
public class Flip_Till_Most_Significant_Bit {
    // The solve method takes an integer A as input and returns the complement up to the most significant bit.
    public int solve(int A) {
        int temp = A; // Initialize a temporary variable to store A
        int pos = 0; // Initialize a variable to keep track of the position of the most significant bit

        // Calculate the position of the most significant bit by counting right shifts
        while (temp > 0) {
            pos++; // Increment pos
            temp = temp >> 1; // Right-shift temp by 1 bit
        }

        // Iterate through each bit from LSB to MSB and flip them
        for (int i = 0; i < pos; i++) {
            A = A ^ (1 << i); // Toggle the i-th bit using bitwise XOR (^)
        }

        return A; // Return the complemented value of A up to the MSB
    }
}
