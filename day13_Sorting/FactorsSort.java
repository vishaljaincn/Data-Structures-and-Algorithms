package day13_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each
element, i.e., element having the least number of factors should be the first to be displayed and the number having
highest number of factors should be the last one. If 2 elements have same number of factors, then number with less
value should come first.

Note: You cannot use any extra space
 */
public class FactorsSort {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        //comparator always work for user defined Classes/Wrapper Classes type not primitive data types.
        Collections.sort(A, new Comparator<Integer>() {
            // Written a compare function to compare two elements
            @Override
            public int compare(Integer a, Integer b) {
                //first find factors of 2 numbers.
                int cfX = factorCount(a);
                int cfY = factorCount(b);
                // Checking if count of X < Count of Y. If true/ -1 cfX will come first in ascending order
                if (cfX < cfY)
                    return -1;
                    //Checking if count of X == Count of Y. and a<b  If true/ -1 cfY will come first in ascending order
                else if (cfX > cfY)
                    return 1;
                    // In Remaining cases, cfY will come first/ 1
                else {
                    if (a <= b)
                        return -1;
                    else
                        return 1;
                }

            }

            // Function to find out count of factors
            public int factorCount(int n) {
                int count = 0;
                for (int i = 1; i * i <= n; i++) {
                    if (n % i == 0) {
                        if (i == n / i) {
                            count++;
                        } else {
                            count = count + 2;
                        }
                    }
                }
                return count;
            }
        });
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(6);
        al.add(8);
        al.add(9);
        System.out.println(solve(al));

    }
}