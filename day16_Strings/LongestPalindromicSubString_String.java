package day16_Strings;

public class LongestPalindromicSubString_String {
    static int start = 0, end = 0, result = 0, maxLength = 0;

    // Helper method to expand around a center to find a palindrome
    public static void expandFromCenter(String s, int center1, int center2) {
        int n=s.length();
        int p1 = center1;
        int p2 = center2;

        // Expand around the center and check for palindromes
        while (p1 >= 0 && p2 < n && s.charAt(p1) == s.charAt(p2)) {
            p1--;
            p2++;
        }

        // Calculate the length of the palindrome found
        result = p2 - p1 - 1;

        // Update the longest palindrome if necessary
        if (maxLength < result) {
            maxLength = result;
            start = p1 + 1;
            end = p2 - 1;
        }
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        // If the length of the string is 1, just return that string
        if (n == 1) {
            return s;
        }

        // Expand around each character as the center for odd-length palindromes
        for (int i = 0; i < n; i++) {
            expandFromCenter(s, i, i); // For odd-length palindromes
        }
        // Expand around each adjacent characters as the center for even-length palindromes
        for (int i = 0; i < n - 1; i++) {
            expandFromCenter(s, i, i + 1); // For even-length palindromes
        }

        return s.substring(start, end + 1); // Longest palindromic substring found
    }

    public static void main(String[] args) {
        String S = "bdyzzydbdyzyd";
        System.out.println(longestPalindrome(S));
    }
}
