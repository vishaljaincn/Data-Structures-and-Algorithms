package day70_Advanced_DP_1_One_Dimensional;

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
 */
/*
Time Complexity: O(N)

Reason: We are running a simple iterative loop

Space Complexity: O(1)

Reason: We are not using any extra space
*/
class Climbing_Stairs_70 {
    // Method to calculate the number of ways to climb stairs using iteration
    public static int climbStairs(int n) {
        // Base case: if n is 1, return 1 (represents the number of ways to climb 1 stair)
        if (n == 1) {
            return 1;
        }

        // Initialize variables to store the previous two Fibonacci numbers and the current Fibonacci number
        int prevPrev = 1;  // Number of ways to climb n-2 stairs
        int prev = 1;      // Number of ways to climb n-1 stairs
        int current = 0;   // Number of ways to climb n stairs

        // Iterate from position 2 to n to calculate the number of ways to climb stairs iteratively
        for (int i = 2; i <= n; i++) {
            current = prev + prevPrev;  // Calculate the number of ways to climb n stairs
            prevPrev = prev;            // Update the number of ways to climb n-2 stairs
            prev = current;             // Update the number of ways to climb n-1 stairs
        }

        // Return the calculated number of ways to climb n stairs
        return current;
    }
}
