package day11_Introduction_To_Bit_Manipulation_2;
/*
You are given two integers A and B.
If B-th bit in A is set, make it unset
If B-th bit in A is unset, make it set
Return the updated A value

 */
public class Toggle_ith_Bit {
    public static int solve(int A, int B) {
        // Toggle the bits
        return (A^(1<<B));
    }

    public static void main(String[] args) {
        System.out.println(solve(4,1));
    }
}
