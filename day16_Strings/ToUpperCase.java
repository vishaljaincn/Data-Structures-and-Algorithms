package day16_Strings;

import java.util.Arrays;

/*
You are given a function to_upper() consisting of a character array A.

Convert each character of A into Uppercase character if it exists. If the Uppercase of a character does not exist,
it remains unmodified.
The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.

Return the uppercase version of the given character array.
 */
public class ToUpperCase {
    public static char[] to_upper(char[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] >= 'a' && A[i] <= 'z') {
                A[i] = (char) (A[i] - 32);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        char[] C = {'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'};
        System.out.println(Arrays.toString(to_upper(C)));
    }
}
