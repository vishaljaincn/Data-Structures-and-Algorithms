package day26_Advanced_Arrays_3_Interview_Problems;

public class Number_Of_Digit_One_In_N_Log_10_N {
    int count = 0; // Initialize a counter to keep track of the number of 1s.

    // Main function to count the number of 1s in numbers from 1 to A.
    public int countDigitOne(int A) {
        for (int i = 1; i <= A; i++) {
            countOnes(i); // Call a helper function to count 1s in the current number.
        }
        return count; // Return the total count of 1s.
    }

    // Helper function to count the number of 1s in a given number n.
    public void countOnes(int n) {
        while (n > 0) {
            int rem = n % 10; // Get the last digit of the number.

            if (rem == 1) {
                count++; // If the last digit is 1, increment the count.
            }

            n = n / 10; // Remove the last digit by dividing the number by 10.
        }
    }
}
