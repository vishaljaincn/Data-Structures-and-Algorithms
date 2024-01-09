package day74_Advanced_DP_5_Strings;

/*
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m
substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 */
/*
 * Time Complexity: O(N*M)
 * Reason: There are N*M states; therefore, at max 'N*M' new problems will be solved.
 *
 * Space Complexity: O(N*M) + O(N+M)
 * Reason: We are using a recursion stack space(O(N+M)) and a 2D array (O(N*M)).
 */
public class Interleaving_Strings_97 {

    // Method to check if C is an interleaving of A and B
    public boolean isInterleave(String A, String B, String C) {
        // If lengths are not the same, then the string cannot be formed
        if (A.length() + B.length() != C.length()) return false;

        int n = A.length();
        int m = B.length();

        // 2D array to memoize subproblem solutions
        Boolean[][] dp = new Boolean[n + 1][m + 1];

        // Start checking for interleaving from the beginning of each string
        return checkInterleave(A, B, C, 0, 0, 0, dp);
    }

    // Recursive method to check interleaving
    private boolean checkInterleave(String A, String B, String C, int i, int j, int k, Boolean[][] dp) {
        // Full string has been made
        if (k == C.length()) return true;

        // If the solution for the current subproblem is already calculated, return it
        if (dp[i][j] != null)
            return dp[i][j];

        boolean ans = false;

        // If character matches, we consider both possibilities and increase the index
        // by taking a character once from A and once from B
        if (i < A.length() && A.charAt(i) == C.charAt(k)) {
            ans = ans || checkInterleave(A, B, C, i + 1, j, k + 1, dp);
        }
        // Check if the current character in string B matches the current character in string C
        // If yes, recursively explore the possibility of forming the interleaved string by advancing the index in string B
        if (j < B.length() && B.charAt(j) == C.charAt(k)) {
            ans = ans || checkInterleave(A, B, C, i, j + 1, k + 1, dp);
        }

        // Memoize the result for the current subproblem and return the answer
        return dp[i][j] = ans;
    }
}
