package day16_Strings;

/*
You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.

Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.

 */
public class CheckAnagrams {
    public static int isAnagram(String A, String B) {
        int n = A.length();
        int m = B.length();

        // Anagrams must have the same length
        if (n != m) {
            return 0;
        }

        int[] freqA = new int[26];
        int[] freqB = new int[26];

        // Count the frequency of characters in string A
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            int index = ch - 'a';
            freqA[index]++;
        }

        // Count the frequency of characters in string B
        for (int i = 0; i < m; i++) {
            char ch = B.charAt(i);
            int index = ch - 'a';
            freqB[index]++;
        }

        // Compare the frequency arrays to check for anagrams
        for (int i = 0; i < 26; i++) {
            if (freqA[i] != freqB[i]) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        String A1 = "cat";
        String B1 = "bat";
        String A2 = "secure";
        String B2 = "rescue";

        System.out.println(isAnagram(A1, B1)); // Output: 0
        System.out.println(isAnagram(A2, B2)); // Output: 1
    }
}
