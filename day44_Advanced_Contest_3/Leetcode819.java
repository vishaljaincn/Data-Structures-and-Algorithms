package day44_Advanced_Contest_3;

import java.util.*;

/*
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
It is guaranteed there is at least one word that is not banned, and that the answer is unique.
The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Example 1:
Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.

Example 2:
Input: paragraph = "a.", banned = []
Output: "a"

Constraints:
1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.

 */
class Leetcode819 {
    public static String mostCommonWord(String paragraph, String[] banned) {
        // Create a map to store word frequencies.
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Create a set of banned words for efficient lookup.
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));

        // Split the paragraph into sentences and convert to lowercase.
        String[] sentences = paragraph.toLowerCase().split("[ !?',;.]+");

        // Iterate through each word in the sentences.
        for (String word : sentences) {
            // Check if the word is not in the banned words.
            if (!bannedWords.contains(word)) {
                // Update the word's frequency in the map.
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        // Initialize variables to keep track of the most frequent word.
        String mostFrequentWord = "";
        int maxFrequency = 0;

        // Iterate through word frequencies to find the most common word.
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > maxFrequency) { //||(frequency == maxFrequency && word.compareTo(mostFrequentWord) < 0)) {
                mostFrequentWord = word;
                maxFrequency = frequency;
            }
        }

        // Return the most frequent word.
        return mostFrequentWord;
    }

    public static void main(String[] args) {
        // Example conversations and banned words
        String conversation = "aa, bb, bb, aa, aa";
        String[] banned = {"aa", "cc"};

        String conversation1 = "xy, d";
        String[] banned1 = {"e", "d"};

        // Find and print the most frequent non-banned word in the conversations
        String mostFrequent = mostCommonWord(conversation, banned);
        System.out.println("Most frequent non-banned word: " + mostFrequent);

        String mostFrequent1 = mostCommonWord(conversation1, banned1);
        System.out.println("Most frequent non-banned word: " + mostFrequent1);
    }
}
