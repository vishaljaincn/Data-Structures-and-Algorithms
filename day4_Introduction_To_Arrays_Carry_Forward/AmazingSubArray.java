package day4_Introduction_To_Arrays_Carry_Forward;

/*
You are given a string S, and you have to find all the amazing substrings of S.

An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Example below

Input
    ABEC

Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
 */
public class AmazingSubArray {
    public static int solve(String A) {
        int n = A.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'a' || A.charAt(i) == 'A' || A.charAt(i) == 'e' || A.charAt(i) == 'E' || A.charAt(i) == 'i' || A.charAt(i) == 'I' || A.charAt(i) == 'o' || A.charAt(i) == 'O' || A.charAt(i) == 'u' || A.charAt(i) == 'U') {
                count = (count + (n - i) % 10003) % 10003;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s="ABEC";
        System.out.println(solve(s));
    }
}
