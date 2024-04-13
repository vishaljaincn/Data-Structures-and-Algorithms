package day37_comparator_and_problems;

import java.util.Arrays;
import java.util.Comparator;

public class HundredthPlaceComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        // Extract the hundredth digit of each number
        int digit1 = (num1 / 100) % 10;
        int digit2 = (num2 / 100) % 10;

        // Compare the digits
        return Integer.compare(digit1, digit2);
    }

    public static void main(String[] args) {
        Integer[] array = {123, 452, 321, 456, 789};

        // Sort the array using the custom comparator
        Arrays.sort(array, new HundredthPlaceComparator());

        // Print the sorted array
        System.out.println("Sorted array with respect to hundredth place digit:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
