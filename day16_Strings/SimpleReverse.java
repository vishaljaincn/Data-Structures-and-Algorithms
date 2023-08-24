package day16_Strings;

/*
Given a string A, you are asked to reverse the string and return the reversed string.
 */
public class SimpleReverse {
    public static String solve(String A) {
        // Create a StringBuilder to store the reversed string
        StringBuilder reversedString = new StringBuilder();

        // Find the length of the input string
        int n = A.length();

        // Traverse the original string in reverse order and append characters to the StringBuilder
        for (int i = n - 1; i >= 0; i--) {
            char character = A.charAt(i);
            reversedString.append(character);
        }

        // Convert the StringBuilder to a string and return it
        return reversedString.toString();
    }

    public static void main(String[] args) {
        String S="Vishal Jain C N";
        System.out.println(solve(S));
    }
}
