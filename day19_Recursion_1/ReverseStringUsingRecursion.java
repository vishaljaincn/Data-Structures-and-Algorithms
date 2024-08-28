package day19_Recursion_1;

public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        String original = "Hello";
        String reversed = reverse(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }

    public static String reverse(String str) {
        // Base case: if the string is empty or has only one character
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        // Recursive case: reverse the substring starting from the second character and append the first character at the end
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
