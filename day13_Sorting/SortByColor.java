package day13_Sorting;

import java.util.Arrays;

/*
Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will represent the colors as,

red -> 0
white -> 1
blue -> 2

Note: Using the library sort function is not allowed.
 */
public class SortByColor {
    public static int[] sortColors(int[] A) {
//        with inbuilt  Sorting it's just two lines of code
//        Arrays.sort(A);
//        return A;
        int n = A.length;
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        // Counting the number of Red, White and Blue Colors
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                redCount++;
            } else if (A[i] == 1) {
                whiteCount++;
            } else if (A[i] == 2) {
                blueCount++;
            }
        }
        // Modifying the Given Array
        for (int i = 0; i < redCount; i++) {
            A[i] = 0;
        }
        for (int i = redCount; i < redCount + whiteCount; i++) {
            A[i] = 1;
        }
        for (int i = redCount + whiteCount; i < redCount + whiteCount + blueCount; i++) {
            A[i] = 2;
        }
        return A;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(sortColors(arr)));
    }
}
