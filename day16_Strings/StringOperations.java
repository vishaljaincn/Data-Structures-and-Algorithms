package day16_Strings;

/*
Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

1. Concatenate the string with itself.
2. Delete all the uppercase letters.
3. Replace each vowel with '#'.

You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after
applying the above operations.

NOTE: 'a', 'e', 'i', 'o', 'u' are defined as vowels.
 */
public class StringOperations {
    public static String manipulateString(String A) {
        // Step 1: Concatenate the string with itself
        A = A + A;

        // Step 2: Delete all uppercase letters
        A = A.replaceAll("[A-Z]", "");

        // Step 3: Replace each vowel with '#'
        A = A.replaceAll("[aeiou]", "#");

        return A;
    }

    public static void main(String[] args) {
        String input = "aeiOUz";
        String result = manipulateString(input);
        System.out.println(result);
    }
}
