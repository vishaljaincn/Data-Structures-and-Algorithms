package leetcode_Extra;

/*
You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

Return the shuffled string.

 Example 1:

Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
Example 2:

Input: s = "abc", indices = [0,1,2]
Output: "abc"
Explanation: After shuffling, each character remains in its position.
 */
class Shuffle_String_1528 {
    public String restoreString(String s, int[] indices) {
        // Create a character array to hold the shuffled string
        char[] shuffled = new char[s.length()];

        // Iterate over the indices array and place each character at its target index
        for (int i = 0; i < indices.length; i++) {
            shuffled[indices[i]] = s.charAt(i);
        }

        // Convert the character array back to a string and return it
        return new String(shuffled);
    }
}