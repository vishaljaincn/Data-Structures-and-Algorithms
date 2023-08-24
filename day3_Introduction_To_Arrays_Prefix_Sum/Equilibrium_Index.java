package day3_Introduction_To_Arrays_Prefix_Sum;
/*Amazon Google Hike
Problem Description
You are given an array A of integers of size N.
Your task is to find the equilibrium index of the given array
The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
Note:
Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.
 */
import java.util.ArrayList;

public class Equilibrium_Index {
    public static int equilibriumIndex(ArrayList<Integer> A) {
        int n = A.size();

        // Calculate the cumulative sum of the array
        for (int i = 1; i < n; i++) {
            A.set(i, A.get(i - 1) + A.get(i));
        }

        int leftSum;
        int rightSum;
        for (int i = 0; i < n; i++) {
            // Calculate the left sum directly using the cumulative sum

            if (i > 0) {
                leftSum = A.get(i - 1);
            } else {
                leftSum = 0;
            }

            // Calculate the right sum directly using the cumulative sum
            rightSum = A.get(n - 1) - A.get(i);

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-7);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(-4);
        arrayList.add(3);
        arrayList.add(0);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(2);
        arrayList2.add(3);
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(1);
        System.out.println(equilibriumIndex(arrayList));
        System.out.println(equilibriumIndex(arrayList2));
        System.out.println(equilibriumIndex(arrayList3));
    }
}
