package day10_Introduction_To_Bit_Manipulation_1;

/*
You have an array A with N elements. We have two types of operation available on this array :
We can split an element B into two elements, C and D, such that B = C + D.
We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1, containing a single element
equal to 0 after several splits and/or merge?
 */
public class InterestingArray {
    public static String solve(int[] A) {
        int n = A.length;
        int count = 0;
        // counting the number of odd elements in the array
        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 1) {
                count++;
            }
        }
        // if the count of odd elements is even return "Yes" or else return "No"
        if (count % 2 == 0) {
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) {
        int[] A1 = {9, 17};
        System.out.println(solve(A1));
        int[] A2 = {1};
        System.out.println(solve(A2));
    }
}
