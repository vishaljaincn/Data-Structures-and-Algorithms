package day43_Advanced_Hashing_2;
/*
given N distinct points in a 2d plane, check how many triangle are formed such that shorter sides are parallel to x-axis and y-axis
 */

import java.util.HashMap;

public class Given_N_Points_How_Many_Triangles {
    public int solve(int[] A, int[] B) {
        int n = A.length;
        HashMap<Integer, Integer> xCounts = new HashMap<>(); // Create a HashMap to count x-coordinates
        HashMap<Integer, Integer> yCounts = new HashMap<>(); // Create a HashMap to count y-coordinates
        int count = 0;

        // Iterate through the points to count x-coordinates and y-coordinates
        for (int i = 0; i < n; i++) {
            int x = A[i];
            int y = B[i];

            // Update the count for the x-coordinate
            xCounts.put(x, xCounts.getOrDefault(x, 0) + 1);

            // Update the count for the y-coordinate
            yCounts.put(y, yCounts.getOrDefault(y, 0) + 1);
        }

        // Calculate the number of triangles that can be formed for each point
        for (int i = 0; i < n; i++) {
            int xCount = xCounts.get(A[i]); // Get the count of the current x-coordinate
            int yCount = yCounts.get(B[i]); // Get the count of the current y-coordinate

            // Subtract 1 to exclude the current point itself when calculating triangles
            count += (xCount - 1) * (yCount - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Given_N_Points_How_Many_Triangles solution = new Given_N_Points_How_Many_Triangles();
        int[] A = {1, 3, 5, 5, 1};
        int[] B = {3, 3, 3, 1, 1};
        int result = solution.solve(A, B);
        System.out.println("Number of triangles: " + result);
    }
}

