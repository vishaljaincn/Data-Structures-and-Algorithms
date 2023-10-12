package day43_Advanced_Hashing_2;

import java.util.HashSet;
/*
Given N 2d points, calculate the number of distinct points
 */
public class Unique_2D_Points {
    public int solve(int[] A, int[] B) {
        // Create a HashSet to store the distinct points
        HashSet<String> distinctPoints = new HashSet<>();

        // Loop through the arrays A and B to create point representations and add them to the HashSet
        for (int i = 0; i < A.length; i++) {
            String point = A[i] + "," + B[i]; // Represent the point as a string, e.g., "x,y"
            distinctPoints.add(point);
        }

        // The size of the HashSet will give you the number of distinct points
        return distinctPoints.size();
    }

    public static void main(String[] args) {
        Unique_2D_Points solution = new Unique_2D_Points();
        int[] A = {1, 2, 3, 1, 2};
        int[] B = {3, 4, 5, 3, 4};
        int distinctCount = solution.solve(A, B);
        System.out.println("Number of distinct points: " + distinctCount);
    }
}
