package day74_Advanced_DP_5_Strings;

/*
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the
string s.

Example 1:
Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.

Example 2:
Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 */
/*
Time Complexity: O(N*N)
Reason: There are two nested loops

Space Complexity: O(N*N)
Reason: We are using an external array of size ‘(N*N)’. Stack Space is eliminated.
 */
class ShortestCommonSuperSequence_1092 {
    // Function to find the shortest common supersequence of two strings
    static String shortestSupersequence(String s1, String s2) {

        // Get the lengths of the input strings
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store the length of the common supersequence
        int[][] dp = new int[n + 1][m + 1];

        // Build the dp array to store the length of the common supersequence
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
/////////////
        // LENGTH OF SHORTEST COMMON SUPER SEQUENCE IS EQUAL TO (n + m - length(lcs))
        // n -> length of string 1
        // m -> length of string 2
        // lcs -> longest common sub sequence of both String 1 and String 2
/////////////
        // Retrieve the common supersequence by backtracking through the dp array
        int i = n;           // Pointer for string s1
        int j = m;           // Pointer for string s2

        StringBuilder ansBuilder = new StringBuilder();  // StringBuilder to construct the common supersequence

        // Backtrack through the dp array to find the characters of the common supersequence
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // If characters are equal, append the character to the result and move both pointers
                ansBuilder.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // If the value above is greater, append the character from s1 and move the s1 pointer
                ansBuilder.append(s1.charAt(i - 1));
                i--;
            } else {
                // If the value on the left is greater, append the character from s2 and move the s2 pointer
                ansBuilder.append(s2.charAt(j - 1));
                j--;
            }
        }

        // Adding remaining characters from either of the two strings if any
        while (i > 0) {
            ansBuilder.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ansBuilder.append(s2.charAt(j - 1));
            j--;
        }

        // Reverse the constructed string to get the final common supersequence
        String ans = ansBuilder.reverse().toString();

        return ans;
    }

    // Main method to test the shortestSupersequence function
    public static void main(String args[]) {
        String s1 = "brute";
        String s2 = "groot";

        System.out.println("The Shortest Common Supersequence is " + shortestSupersequence(s1, s2));
    }
}