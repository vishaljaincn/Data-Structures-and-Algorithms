package day19_Recursion_1;

/*
 Write a recursive function that checks whether string A is a palindrome or Not.
 Return 1 if the string A is a palindrome, else return 0.

 Note: A palindrome is a string that's the same when read forward and backward.
 */
public class CheckPalindrome {
    // Recursive function to check whether a given string is a palindrome
    public static int solve(String A) {
        int start = 0;
        int end = A.length() - 1;
        return checkPalindrome(A, start, end);
    }

    public static int checkPalindrome(String A, int start, int end) {
        if (start >= end) {
            return 1; // Base case: string is a palindrome
        }
        if (A.charAt(start) == A.charAt(end)) {
            return checkPalindrome(A, start + 1, end - 1); // Move both pointers inward
        }
        return 0; // If characters don't match, string is not a palindrome
    }

    public static void main(String[] args) {
        String S = "vishaljain";
        String S1 = "lol";
        System.out.println(solve(S)); // Print 0 (not a palindrome)
        System.out.println(solve(S1)); // Print 1 (is a palindrome)
    }
}
