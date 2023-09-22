package day24_Advanced_Arrays_1_One_Dimensional;

public class Flip {
    public static int[] flip(String A) {
        int currentSum = 0;
        int finalSum = Integer.MIN_VALUE;
        int start = 0;      // Starting index of the maximum subarray.
        int end = 0;        // Ending index of the maximum subarray.
        int tempStart = 0;  // Starting index of the current subarray.

        // Iterate through the input string{CALCULATING MAXIMUM NET GAIN OF 1's}
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') {
                currentSum = currentSum + 1;  // Increment sum for '0'
            }
            if (A.charAt(i) == '1') {
                currentSum = currentSum - 1;  // Decrement sum for '1'
            }

            // Update maximum sum and subarray indices if current sum is greater
            if (currentSum > finalSum) {
                finalSum = currentSum;
                start = tempStart;
                end = i;
            }

            // Reset sum and update tempStart if current sum becomes negative
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        // If the entire array consists of '1's, return an empty array
        if (finalSum < 0) {
            return new int[0];
        }

        int res[] = new int[2];

        res[0] = start + 1; //Adding +1 here because in the question they've given 1 based indexing
        res[1] = end + 1;   //Adding +1 here because in the question they've given 1 based indexing
        return res;
    }

    // Main function to demonstrate the usage of the flip method
    public static void main(String[] args) {
        Flip solution = new Flip();
        String input = "010101110";
        int[] result = solution.flip(input);

        if (result.length == 0) {
            System.out.println("No flip possible.");
        } else {
            System.out.println("Flip subarray from index " + result[0] + " to " + result[1]);
        }
    }
}
