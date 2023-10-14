package day44_Advanced_Contest_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
Given an array A of size N, your task is to rearrange the words in increasing order of their length;
if 2 words of same length, arrange them in their original order as it occurs in the arraylist
 */
public class Increasing_Order_Words {
    public static ArrayList<String> solve(ArrayList<String> A) {
        // Sort the ArrayList A based on the length of strings in ascending order.
        Collections.sort(A, new Comparator<String>() {
            public int compare(String A, String B) {
                int X = A.length();
                int Y = B.length();
                // THIS WILL TAKE CARE OF STABLE SORTING ALSO,
                // SO NO NEED TO CONSIDER SORTING BASED ON INDICES
                return Integer.compare(X, Y);
            }
        });
        return A;
    }

    public static void main(String[] args) {

        // Test case 1: ArrayList of strings
        ArrayList<String> input1 = new ArrayList<>();
        input1.add("u");
        input1.add("psv");
        input1.add("kg");
        input1.add("lwf");
        input1.add("ul");
        input1.add("g");
        input1.add("e");
        input1.add("qt");

        System.out.println("Original input: " + input1);
        ArrayList<String> result1 = solve(input1);
        System.out.println("Sorted result: " + result1);

        // Test case 2: ArrayList with different lengths
        ArrayList<String> input2 = new ArrayList<>();
        input2.add("apple");
        input2.add("banana");
        input2.add("kiwi");
        input2.add("grape");
        input2.add("orange");

        System.out.println("Original input: " + input2);
        ArrayList<String> result2 = solve(input2);
        System.out.println("Sorted result: " + result2);

        // Test case 3: ArrayList with duplicate lengths
        ArrayList<String> input3 = new ArrayList<>();
        input3.add("dog");
        input3.add("cat");
        input3.add("rat");
        input3.add("bat");

        System.out.println("Original input: " + input3);
        ArrayList<String> result3 = solve(input3);
        System.out.println("Sorted result: " + result3);
    }
}

