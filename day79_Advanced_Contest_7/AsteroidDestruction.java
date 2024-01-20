package day79_Advanced_Contest_7;

/*
In a faraway galaxy, there is a spaceship traveling through the asteroid field. The spaceship has a shield with a
certain amount of energy. You are given an integer energy A, which represents the original energy of the shield.
You are further given an integer array B of size N, where B[i] is the energy of the i-th asteroid.
You can arrange for the spaceship to collide with the asteroids in any arbitrary order. If the energy of the shield is
greater than or equal to the energy of the asteroid, the asteroid is destroyed and the shield gains the energy of the
asteroid. Otherwise, the shield is destroyed.
Return 1 if all asteroids can be destroyed. Otherwise, return 0.
Problem Constraints
1 <= A <= 109
1 <= N <= 105
1 <= B[i] <= 109
Input Format
First argument A is an integer.
Second argument B is an integer array.
Output Format
Return an integer.
 */
//Time Complexity : O(N LogN)
//Space Complexity : O(1)

import java.util.Arrays;

public class AsteroidDestruction {
    public int solve(int A, int[] B) {
        // Get the length of the asteroid array
        int n = B.length;

        // Convert initial energy to long to prevent overflow during calculations
        long spaceshipEnergy = A;

        // Sort the asteroids in ascending order
        Arrays.sort(B);

        // Iterate through the asteroids
        for (int i = 0; i < n; i++) {
            // If the shield's energy is less than the current asteroid's energy, it cannot be destroyed
            if (spaceshipEnergy < B[i]) {
                return 0;
            } else {
                // Otherwise, destroy the asteroid and update the shield's energy
                spaceshipEnergy += B[i];
            }
        }

        // All asteroids can be destroyed
        return 1;
    }
}

