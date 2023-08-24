package day16_Strings;
/*
You are given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number
of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.
 */

import java.util.Arrays;

public class ChangeCharacter {
    public int solve(String A, int B) {
        int n = A.length();
//edge cases
        if (B >= n) {
            return 1;
        }
//create a frequency array
        int freq[] = new int[26];
        for (int i = 0; i < n; i++) {
            int index = A.charAt(i) - 'a';
            freq[index]++;
        }
//calculate total charaters
        int total = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                total++;
            }
        }
//sort the freq array
        Arrays.sort(freq);
//Calculate changes
        int changes = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0 && B - freq[i] >= 0) {
                B -= freq[i];
                changes++;
            }
        }
//return min distinct characters
        return total - changes;
    }
}
