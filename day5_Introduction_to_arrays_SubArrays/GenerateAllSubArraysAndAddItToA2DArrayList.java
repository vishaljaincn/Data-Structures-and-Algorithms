package day5_Introduction_to_arrays_SubArrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array

Note : The order of the subarrays in the resulting 2D array does not matter.
 */
public class GenerateAllSubArraysAndAddItToA2DArrayList {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
        int n=A.size();
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                ArrayList<Integer> a=new ArrayList<Integer>();
                for(int k=i;k<=j;k++)
                {
                    a.add(A.get(k));
                }
                al.add(a);
            }
        }
        return al;
    }

    public static void main(String[] args) {
        ArrayList<Integer>al =new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println((solve(al)));
    }

}
