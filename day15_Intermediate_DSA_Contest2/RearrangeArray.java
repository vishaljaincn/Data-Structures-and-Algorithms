package day15_Intermediate_DSA_Contest2;
/*
This function takes an ArrayList of integers A as input and rearranges the array such that every consecutive pair of
integers have opposite signs, while preserving the order of integers with the same sign. The rearranged array must
begin with a negative integer. The array always has an even length and consists of an equal number of positive and
negative integers.

    Constraints:
    - 1 <= N <= 10^5 (size of the array)
    - A[i] != 0
    - N is even

    The function returns an ArrayList containing the rearranged array.
 */
import java.util.ArrayList;

public class RearrangeArray {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> positiveNumber = new ArrayList<Integer>();
        ArrayList<Integer> negativeNumber = new ArrayList<Integer>();

        // Separate positive and negative numbers into separate ArrayLists
        for (int i = 0; i < n; i++) {
            if (A.get(i) < 0) {
                negativeNumber.add(A.get(i));
            }
            if (A.get(i) > 0) {
                positiveNumber.add(A.get(i));
            }
        }

        ArrayList<Integer> finalArrangement = new ArrayList<Integer>();

        // Merge the positive and negative numbers in the required alternating pattern
        for (int i = 0; i < n / 2; i++) {
            finalArrangement.add(negativeNumber.get(i));
            finalArrangement.add(positiveNumber.get(i));
        }

        return finalArrangement; // Return the rearranged ArrayList
    }

    public static void main(String[] args) {
        // Example usage of the solve function with a sample input
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(3);
        al.add(-1);
        al.add(-5);
        System.out.println(solve(al)); // Output: [-1, 2, -5, 3] (Rearranged array with alternating signs)
    }
}
