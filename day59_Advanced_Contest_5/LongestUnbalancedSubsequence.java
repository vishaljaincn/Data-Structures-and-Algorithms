package day59_Advanced_Contest_5;
/*
An input string A of length N is balanced if:
open parentheses must be closed by closed parentheses.
Every close bracket has a corresponding open bracket of the same type;
you have been given a string with '{' and '}', also called as parentheses. Your task is to find the
"longest Unbalanced Subsequence" of the given string
give java code

Input 1:
A={{}}
output 1:
3
Input 2:
A={{{}
Output 2:
4
Example 1 explanation: given string is balanced, so we cannot take the whole string as an unbalanced subsequence,
removing a character from it will make the string unbalanced so the answer is 3.
Example 2 explanation: given string is unbalanced, so we can take the whole string as an unbalanced subsequence
so the answer is 4
 */

import java.util.Stack;

public class LongestUnbalancedSubsequence {
    public static int solve(String A) {
        // Stack to keep track of open parentheses
        Stack<Character> stack = new Stack<>();

        // Traverse the characters in the input string
        for (char c : A.toCharArray()) {
            if (c == '{') {
                // If character is '{', push it onto the stack
                stack.push(c);
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                // If character is '}', and there is a corresponding '{' on the stack, pop it
                stack.pop();
            } else {
                // If the string is unbalanced,
                // Return the length of the original string
                return A.length();
            }
        }

        // If the stack is empty, the string is balanced
        if (stack.isEmpty()) {
            // Return the length of the string minus 1
            // (since we need to remove one character to make it unbalanced)
            return A.length() - 1;
        } else {
            // If the stack is not empty, the string is unbalanced
            // Return the length of the original string
            return A.length();
        }
    }

    public static void main(String[] args) {
        // Example usage
        String input1 = "{{}}";
        String input2 = "}}}}";

        // Output: 3
        System.out.println(solve(input1));

        // Output: 4
        System.out.println(solve(input2));
    }
}
