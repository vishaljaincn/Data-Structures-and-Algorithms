package day16_Strings;

/*
Given a string A of size N, find and return the length of the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

In case of conflict, return the substring which occurs first (with the least starting index).
*/
public class LongestPalindromicSubString_Length {
    public static int longestPalindrome(String A) {
        int longestLength = 0; // Stores the length of the longest palindromic substring found so far
        int n = A.length(); // Length of the input string

        // Expand around each character as the center for odd-length palindromes
        for (int i = 0; i < n; i++) {
            int lengthOdd = expandAroundCenter(A, i, i); // Find the length of the odd-length palindrome
            longestLength = Math.max(longestLength, lengthOdd); // Update longestLength if necessary
        }

        // Expand around each adjacent characters as the center for even-length palindromes
        for (int i = 0; i < n - 1; i++) {
            int lengthEven = expandAroundCenter(A, i, i + 1); // Find the length of the even-length palindrome
            longestLength = Math.max(longestLength, lengthEven); // Update longestLength if necessary
        }

        return longestLength;
    }

    // Helper method to expand around a center to find a palindrome
    public static int expandAroundCenter(String A, int center1, int center2) {
        int p1 = center1;
        int p2 = center2;
        int n = A.length(); // Length of the input string
        while (p1 >= 0 && p2 < n && A.charAt(p1) == A.charAt(p2)) {
            p1--; // Expand left
            p2++; // Expand right
        }
        return p2 - p1 - 1; // Length of the palindrome found
    }

    public static void main(String[] args) {
        String S = "bdyzzydbdyzyd";
        System.out.println(longestPalindrome(S));
    }
}
