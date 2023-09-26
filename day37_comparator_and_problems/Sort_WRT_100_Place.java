package day37_comparator_and_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
sort an integer array with respect to digit in 100 place
 */
public class Sort_WRT_100_Place {

    // Function to sort an array based on the digit in the 100s place
    static void sortBy100sPlace(int[] arr) {
        // Create a HashMap to store integers grouped by their 100s place digit
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Iterate through the array and group integers based on the 100s place digit
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            // Calculate the digit in the 100s place
            int digit = (num / 100) % 10;

            // If there's no ArrayList for this digit, create one
            if (!map.containsKey(digit)) {
                map.put(digit, new ArrayList<>());
            }

            // Add the number to the appropriate group
            map.get(digit).add(num);
        }

        // Reassemble the sorted result
        int index = 0;
        // Iterate through digits from 0 to 9
        for (int digit = 0; digit <= 9; digit++) {
            // If there are numbers in the group for this digit
            if (map.containsKey(digit)) {
                ArrayList<Integer> group = map.get(digit);
                // Copy the numbers back to the original array
                for (int j = 0; j < group.size(); j++) {
                    arr[index] = group.get(j);
                    index++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 266};
        System.out.println("Original Array: " + Arrays.toString(arr));

        // Call the sorting function
        sortBy100sPlace(arr);

        System.out.println("Sorted Array based on 100s place: " + Arrays.toString(arr));
    }
}
