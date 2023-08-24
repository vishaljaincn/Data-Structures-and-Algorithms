package day14_Interview_Problems;

/*
Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
Find and return the length of the longest consecutive 1’s that can be achieved.
 */
public class Length_Of_Longest_Consecutive_Ones_With_At_Max_One_Swap {
    // Function to find the length of the longest consecutive 1's after at most one swap.
    public static int solve(String A) {
        int n = A.length(); // Length of the input binary string
        int maxLength = 0; // Variable to store the maximum length of consecutive 1's found so far
        int totalNoOfOnes = 0; // Variable to count the total number of 1's in the input string

        // /////////////////////////////////////////////////////////////////////////////////////////////////////

// Total number of Max iterations will be 3*N, So the TC is O(N), SC - O(1)

        // Count the total number of 1's in the input string A
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                totalNoOfOnes++;
            }
        }
//        System.out.println("Total number of 1's in the input string: " + totalNoOfOnes);

        // Edge case if all the numbers present in the String are 1
        if (totalNoOfOnes == n) {
            return n;
        }

        // Iterate through the binary string to find 0's
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') { // Check for '0' character
                int left = 0; // Variable to count consecutive 1's to the left of the current '0'
                int right = 0; // Variable to count consecutive 1's to the right of the current '0'

                // Count consecutive 1's to the left of the current '0'
                for (int j = i - 1; j >= 0; j--) {
                    if (A.charAt(j) == '1') {
                        left++;
                    } else {
                        break;
                    }
                }

                // Count consecutive 1's to the right of the current '0'
                for (int j = i + 1; j < n; j++) {
                    if (A.charAt(j) == '1') {
                        right++;
                    } else {
                        break;
                    }
                }

                // Calculate the current length of consecutive 1's by adding left + right + 1 (for the current '0')
                int currentLength = left + right + 1;

                // Check if the current length is greater than totalNoOfOnes
                if (currentLength > totalNoOfOnes) {
                    currentLength = left + right; // If so, remove (+1)
                }
//                No need to write this else part,It's redundant
                else {
                    currentLength = left + right + 1; // Otherwise, keep it as it is
                }

                // Update the maxLength if the currentLength is greater
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }
        return maxLength; // Return the length of the longest consecutive 1's achievable after at most one swap
    }

    public static void main(String[] args) {
        String s1 = "111000";
        String s2 = "111011101";
        System.out.println("Length of longest consecutive 1's in s1: " + solve(s1));
        System.out.println("Length of longest consecutive 1's in s2: " + solve(s2));
    }
}
