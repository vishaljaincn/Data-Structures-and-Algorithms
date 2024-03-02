package day55_Advanced_Stacks_2;

import java.util.Stack;
/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */

// Time complexity: O(n), Space complexity: O(n)

//REFER EXAMPLE 3 GIVEN IN QUESTION AND DRY RUN THR CODE, YOU'LL GET BETTER UNDERSTANDING ON HOW THE CODE WORKS

public class AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        // Iterate through each asteroid
        for (int currentAsteroid : asteroids) {
            // Handle collisions with asteroids moving to the left
            while (!stack.isEmpty() && stack.peek() > 0 && currentAsteroid < 0) {
                int top = stack.pop();

                // Both asteroids explode if their sizes are equal
                if (Math.abs(top) == Math.abs(currentAsteroid)) {
                    currentAsteroid = 0; // Destroy both asteroids
                    break;
                } else if (Math.abs(top) > Math.abs(currentAsteroid)) {
                    currentAsteroid = top; // Current asteroid is destroyed
                }
            }

            // If the current asteroid is not destroyed in a collision, push it to the stack
            if (currentAsteroid != 0) {
                stack.push(currentAsteroid);
            }
        }

        // Convert the stack to an array for the final result
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
