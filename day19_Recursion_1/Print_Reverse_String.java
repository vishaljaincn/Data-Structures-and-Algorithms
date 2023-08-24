package day19_Recursion_1;
/*
Write a recursive function that takes a string, S, as input and prints the characters of S in reverse order.
 */
import java.util.Scanner;

public class Print_Reverse_String {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a String");
        // Input a string from the user
        String inputString = sc.nextLine();

        // Calculate the last index of the string
        int lastIndex = inputString.length() - 1;

        // Call the reverseString function to print the string in reverse
        reverseString(inputString, lastIndex);

        // Close the scanner
        sc.close();
    }

    public static void reverseString(String str, int currentIndex) {
        // Base case: If currentIndex is 0, print the character and return
        if (currentIndex == 0) {
            System.out.print(str.charAt(currentIndex));
            return;
        }

        // Print the character at currentIndex
        System.out.print(str.charAt(currentIndex));

        // Recursively call reverseString with the previous index
        reverseString(str, currentIndex - 1);
    }
}
