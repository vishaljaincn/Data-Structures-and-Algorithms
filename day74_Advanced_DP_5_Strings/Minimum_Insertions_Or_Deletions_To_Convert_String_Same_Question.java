package day74_Advanced_DP_5_Strings;
/*
Problem Statement: Minimum Insertions/Deletions to Convert String A to String B
We are given two strings, str1 and str2. We are allowed the following operations:

Delete any number of characters from string str1.
Insert any number of characters in string str1.
We need to tell the minimum operations required to convert str1 to str2.
 */
/*
Time Complexity: O(N*M)
Reason: There are two nested loops

Space Complexity: O(N*M)
Reason: We are using an external array of size ‘N*M)’. Stack Space is eliminated.
 */
class Minimum_Insertions_Or_Deletions_To_Convert_String_Same_Question {
    // Function to find the length of the Longest Common Subsequence (LCS)
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store the LCS lengths
        int dp[][] = new int[n + 1][m + 1];

        // Fill the dp array using a bottom-up approach
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }

    // Function to find the minimum operations required to convert str1 to str2
    static int minDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Find the length of the LCS between str1 and str2
        int k = lcs(str1, str2);

        // The minimum operations required is the sum of the lengths of str1 and str2
        // minus twice the length of LCS
        return (n - k) + (m - k);
    }
}
