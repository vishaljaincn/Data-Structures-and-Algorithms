package day76_Advanced_Graphs_1_DFS_BFS;

import java.util.*;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation: We cannot reach the target without getting stuck.
 */

// Time Complexity - O(10^4)
// The worst-case scenario involves visiting all possible combinations of the
// lock, which is 10^4 (since each digit can take values from 0 to 9).
// Space Complexity - O(10^4)
// Both time and space complexity are dominated by the number of possible lock combinations.

public class OpenTheLock_752 {
    public int openLock(String[] deadends, String target) {
        // Set to store deadends for constant time lookup
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        // Set to track visited states to avoid revisiting
        Set<String> visited = new HashSet<>();

        // Queue for BFS traversal
        Queue<String> queue = new LinkedList<>();

        // Starting point: "0000"
        queue.offer("0000");
        visited.add("0000");

        // Steps to reach the target
        int steps = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Explore current level
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Check if the current state is a deadend
                if (deadendSet.contains(current)) {
                    continue; // Skip deadends to avoid unnecessary exploration
                }

                // Check if the target is reached
                if (current.equals(target)) {
                    return steps; // Target is reached, return the number of steps
                }

                // Generate neighbors for the current state
                for (int j = 0; j < 4; j++) {
                    // Move up
                    String up = increment(current, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }

                    // Move down
                    String down = decrement(current, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }

            // Move to the next level
            steps++;
        }

        // If no solution is found
        return -1;
    }

    // Helper method to increment the digit at a specific position
    private String increment(String s, int position) {
        char[] chars = s.toCharArray();
        if (chars[position] == '9') {
            chars[position] = '0';
        } else {
            chars[position]++;
        }
        return new String(chars);
    }

    // Helper method to decrement the digit at a specific position
    private String decrement(String s, int position) {
        char[] chars = s.toCharArray();
        if (chars[position] == '0') {
            chars[position] = '9';
        } else {
            chars[position]--;
        }
        return new String(chars);
    }
}
