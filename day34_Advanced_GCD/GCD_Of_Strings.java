package day34_Advanced_GCD;

/*
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or
more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 */
public class GCD_Of_Strings {
    /////
    //TC - O(m+n), m-length of str1, n-length of str2
    // This method finds the greatest common divisor of two strings.
    public String gcdOfStrings(String str1, String str2) {
        // Check if concatenated strings are equal or not, if not return "".
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Get the GCD of the two lengths.
        int gcdLength = gcd(str1.length(), str2.length());

        // Return a substring of str1 from index 0 to gcdLength (exclusive).
        return str1.substring(0, gcdLength);
    }

    // This is a helper method to find the GCD of two integers using the Euclidean algorithm.
    public int gcd(int A, int B) {
        // Base case: If B is 0, A is the GCD.
        if (B == 0) {
            return A;
        }

        // Recursively call gcd with B and A % B until B becomes 0.
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        GCD_Of_Strings gcdCalculator = new GCD_Of_Strings();

        // Example 1
        String str1 = "ABCABC";
        String str2 = "ABC";
        String result1 = gcdCalculator.gcdOfStrings(str1, str2);
        System.out.println("Example 1 Result: " + result1); // Output should be "ABC"

        // Example 2
        String str3 = "ABABAB";
        String str4 = "ABAB";
        String result2 = gcdCalculator.gcdOfStrings(str3, str4);
        System.out.println("Example 2 Result: " + result2); // Output should be "AB"

        // Example 3
        String str5 = "LEET";
        String str6 = "CODE";
        String result3 = gcdCalculator.gcdOfStrings(str5, str6);
        System.out.println("Example 3 Result: " + result3); // Output should be ""

        // Additional Example
        String str7 = "ABCDEF";
        String str8 = "ABC";
        String result4 = gcdCalculator.gcdOfStrings(str7, str8);
        System.out.println("Additional Example Result: " + result4); // Output should be ""

    }
}
