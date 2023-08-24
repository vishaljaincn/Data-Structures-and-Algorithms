package day16_Strings;
/*
You are given a string A of size N.
Return the string A after reversing the string word by word.
NOTE:
A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
public class Reverse_The_String {

    public static String reverseWords(String A) {
        // Trim leading and trailing spaces from the input string
        A = A.trim();

        // Split the trimmed string into words using space as the delimiter
        String[] words = A.split(" ");
        int n = words.length;

        // Create a StringBuilder to store the reversed string
        StringBuilder reversedString = new StringBuilder();

        // Traverse the words array in reverse order and append them to the reversedString
        for (int i = n - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            if (i > 0) {
                // Append a single space after each word (except the last word)
                reversedString.append(" ");
            }
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        String S = "the sky is blue";
        System.out.println(reverseWords(S));
    }
}
