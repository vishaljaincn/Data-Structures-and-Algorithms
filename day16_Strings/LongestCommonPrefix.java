package day16_Strings;

/*
Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the
array.

The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and
S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] A) {
        if (A == null || A.length == 0) {
            return ""; // Return an empty string if the array is empty or null
        }

        // Initialize the longest common prefix with the first string in the array
        String longestPrefix = A[0];

        // Compare each subsequent string with the current longestPrefix to find the common prefix
        for (int i = 1; i < A.length; i++) {
            String currentString = A[i];
            int j = 0;

            // Find the common prefix character by character
            while (j < longestPrefix.length() && j < currentString.length() && longestPrefix.charAt(j) == currentString.charAt(j)) {
                j++;
            }

            // Update the longestPrefix to contain only the common prefix found in the current string and the previous prefix
            longestPrefix = longestPrefix.substring(0, j);
        }

        return longestPrefix; // Return the longest common prefix
    }

    public static void main(String[] args) {
        // Test case 1: Empty array
        String[] strings1 = {};
        System.out.println("Test case 1: " + longestCommonPrefix(strings1)); // Output: ""

        // Test case 2: Array with a single string
        String[] strings2 = {"abcdefgh"};
        System.out.println("Test case 2: " + longestCommonPrefix(strings2)); // Output: "abcdefgh"

        // Test case 3: Array with multiple strings having a common prefix
        String[] strings3 = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println("Test case 3: " + longestCommonPrefix(strings3)); // Output: "a"

        // Test case 4: Array with multiple strings having a common prefix
        String[] strings4 = {"abab", "ab", "abcd"};
        System.out.println("Test case 4: " + longestCommonPrefix(strings4)); // Output: "ab"

        // Test case 5: Array with no common prefix
        String[] strings5 = {"abcd", "efgh", "ijkl"};
        System.out.println("Test case 5: " + longestCommonPrefix(strings5)); // Output: ""
    }
}
