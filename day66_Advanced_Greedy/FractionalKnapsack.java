package day66_Advanced_Greedy;
//INSTEAD OF VALUE THEY CAN GIVE PROTEIN CONTENT, INSTEAD OF WEIGHT THEY CAN GIVE QUANTITY, THEN SORT THE ITEMS IN DECREASING
//ORDER OF PROTEIN CONTENT/PER KG
/*
Problem Statement: The weight of N items and their corresponding values are given. We have to put these items in a knapsack of weight W such that the total value obtained is maximized.

Note: We can either take the item as a whole or break it into smaller units.

Example:

Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.

Output: 240.00

Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. Total value = 100 + 60 + 80 = 240.00
 */
/*
Time Complexity: O(n log n + n). O(n log n) to sort the items and O(n) to iterate through all the items for calculating the answer.

Space Complexity: O(1), no additional data structure has been used.
 */
// Importing necessary libraries

import java.util.Arrays;
import java.util.Comparator;

// Class to represent an item with its value and weight
class Item {
    int value, weight;

    // Constructor to initialize the item
    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

// Comparator class to compare items based on their value-to-weight ratios
class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        // Calculate value-to-weight ratios for both items
        double r1 = (double) (a.value) / (double) (a.weight);
        double r2 = (double) (b.value) / (double) (b.weight);

        // Use Integer.compare to compare based on the ratios
        return Integer.compare((int) r2, (int) r1); // Reverse the order for non-increasing order
    }

}

// Class to solve the Fractional Knapsack problem
public class FractionalKnapsack {
    // Function to calculate the maximum value that can be obtained in the knapsack
    static double fractionalKnapsack(int W, Item arr[], int n) {
        // Sort the items based on their value-to-weight ratios in non-increasing order
        Arrays.sort(arr, new itemComparator());

        int curWeight = 0;  // Current weight in the knapsack
        double finalvalue = 0.0;  // Final value of items selected in the knapsack

        // Iterate through the sorted items
        for (int i = 0; i < n; i++) {
            // Check if the entire item can be added to the knapsack
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;  // Add the entire item
                finalvalue += arr[i].value;  // Update the final value
            } else {
                // If the entire item cannot be added, add a fraction of it to fill the knapsack
                int remain = W - curWeight;
                finalvalue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }

        return finalvalue;
    }

    // Main method to test the Fractional Knapsack algorithm
    public static void main(String args[]) {
        // Input values for the problem
        int n = 3, weight = 50;
        Item arr[] = {new Item(100, 20), new Item(60, 10), new Item(120, 30)};

        // Call the fractionalKnapsack function and print the result
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is " + ans);
    }
}
