package day3_Introduction_To_Arrays_Prefix_Sum;

import java.util.ArrayList;

public class PrefixSumOfTheGivenArrayItself {
    public static ArrayList<Integer> prefixSumOfTheGivenArrayItself(ArrayList<Integer> A) {
        int n=A.size();
        for(int i=1;i<n;i++)
        {
            A.set(i,A.get(i-1)+A.get(i));
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(prefixSumOfTheGivenArrayItself(arrayList));
    }
}
