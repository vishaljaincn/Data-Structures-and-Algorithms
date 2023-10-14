package day44_Advanced_Contest_3;

import java.util.*;

/*
the conversion transcript is a string array of size N, and banned words are given in string array B of size M, 
write a program to return the most frequently used word in the conversion that is not in the banned list, 
if there are multiple words with the highest frequency, return the lexicographically smallest one, 
Note : return an empty string if all the words in the conversation is banned
 */
public class Detective_And_Banned_Words {
    // Function to find the most frequently used non-banned word in a conversation
    public static String findMostFrequentWord(String[] conversation, String[] banned) {
        // Create a map to store word frequencies
        Map<String, Integer> freq = new HashMap<>();
        // Create a set to store banned words for efficient lookup
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));

        // Iterate through the conversation
        for (String word : conversation) {
            // Check if the word is not in the banned list
            if (!bannedWords.contains(word)) {
                // Update the word's frequency in the map
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // Initialize variables to track the most frequent word
        String mostFreqWord = "";
        int maxFreq = 0;

        // Iterate through the word frequency map
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();

            // Check if the current word has a higher frequency or is lexicographically smaller
            if (frequency > maxFreq || (frequency == maxFreq && word.compareTo(mostFreqWord) < 0)) {
                mostFreqWord = word;
                maxFreq = frequency;
            }
        }

        // Return the most frequent non-banned word
        return mostFreqWord;
    }

    public static void main(String[] args) {
        // Example conversations and banned words
        String[] conversation = {"aa", "bb", "bb", "aa", "aa"};
        String[] banned = {"aa", "cc"};

        String[] conversation1 = {"xy", "pq", "d"};
        String[] banned1 = {"e", "d"};

        // Find and print the most frequent non-banned word in the conversations
        String mostFrequent = findMostFrequentWord(conversation, banned);
        System.out.println("Most frequent non-banned word: " + mostFrequent);

        String mostFrequent1 = findMostFrequentWord(conversation1, banned1);
        System.out.println("Most frequent non-banned word: " + mostFrequent1);
    }
}
