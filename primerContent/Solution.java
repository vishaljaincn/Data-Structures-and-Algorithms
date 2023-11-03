package primerContent;

import java.util.Stack;

public class Solution {
    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        int steps = 0;

        for (char c : A.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                steps++;
            } else {
                stack.push(c);
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(solve("baab")); // Should print 2
        System.out.println(solve("ab"));   // Should print 1
    }
}
