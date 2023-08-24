package day16_Strings;

import java.util.Arrays;

/*
Given a char array C, which only contains lowercase alphabets, sort the given C[] in alphabetical order.
*/
public class Sort_In_Alphabetical_Order {
    public static char[] sortAlphabetically(char[] C) {
        // Find the length of the input char array
        int n = C.length;

        // Create a frequency array to store the count of occurrences of each character
        int[] frequency = new int[26];

        // Count the occurrences of each character in the input char array
        for (int i = 0; i < n; i++) {
            int index = C[i] - 'a';
            frequency[index]=frequency[index]+1;
        }

        // Reconstruct the sorted char array based on the frequency array
        int k = 0; // Position pointer for the sorted char array C
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            for (int j = 0; j < frequency[i]; j++) {
                C[k] = ch;
                k++;
            }
        }

        return C;
    }

    public static void main(String[] args) {
        char[] C = {'b', 'c', 'a', 'z', 'e', 'a', 'n', 'c'};
        char[] sortedC = sortAlphabetically(C);
        System.out.println(Arrays.toString(sortedC));
    }
}
