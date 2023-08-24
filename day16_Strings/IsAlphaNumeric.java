package day16_Strings;

/*
You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.
 */
public class IsAlphaNumeric {

    public static int isAlphaNumeric(char[] A) {
        int n = A.length;

        // Iterate through each character in the array
        for (int i = 0; i < n; i++) {
            // Check if the character is an alphabet (uppercase or lowercase) or a digit
            if ((A[i] >= 'A' && A[i] <= 'Z') || (A[i] >= 'a' && A[i] <= 'z') || (A[i] >= '0' && A[i] <= '9')) {
                // If it is, continue to the next character
                continue;
            } else {
                // If it is not an alphanumeric character, return 0 (false)
                return 0;
            }
        }
        // If all characters are alphanumeric, return 1 (true)
        return 1;
    }

    public static void main(String[] args) {
        char[]C1={'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};
        char[]C2={'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.println(isAlphaNumeric(C1));
        System.out.println(isAlphaNumeric(C2));
    }
}
