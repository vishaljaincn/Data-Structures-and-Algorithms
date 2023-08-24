package day13_Sorting;

import java.util.*;

/*
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static String largestNumber(final List<Integer> A) {
//        Creating a new List because the given list is final and cannot be modified(sorted)
        ArrayList<Integer> A1=new ArrayList<>(A);
        int n=A1.size();
        Collections.sort(A1, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String X = String.valueOf(a)+String.valueOf(b);;
                String Y = String.valueOf(b)+String.valueOf(a);;
//     here we have used Y.compareTo(X) to sort in descending order, For Ascending order we would have used X.compareTo(Y)
                return Y.compareTo(X);
            }
        });
//      handle the special case of an array containing only zeros, ensuring that we return "0" instead of "0000".
        if(A1.get(0)==0)
        {
            return "0";
        }
//        Concatenate the sorted numbers to form the largest number using a String Builder
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            stringBuilder.append(A1.get(i));
        }
//        Finally convert StringBuilder to String
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        List<Integer> al=Arrays.asList(89,8);
        System.out.println(largestNumber(al));
    }
}
