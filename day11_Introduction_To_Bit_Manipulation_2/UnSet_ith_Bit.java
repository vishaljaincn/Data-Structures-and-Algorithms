package day11_Introduction_To_Bit_Manipulation_2;
/*
You are given two integers A and B.
If B-th bit in A is set, make it unset.
If B-th bit in A is unset, leave as it is.
Return the updated A value.
 */
public class UnSet_ith_Bit {
    public static int solve(int A, int B) {
        // Checking if the bit is set or not
        if((A & (1<<B))==(1<<B))
        {
            // if the bit is set, we are unsetting it
            A = (A ^ (1<<B));
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(solve(4,1));
    }
}
