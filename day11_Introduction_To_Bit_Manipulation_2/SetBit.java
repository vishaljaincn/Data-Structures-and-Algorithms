package day11_Introduction_To_Bit_Manipulation_2;
/*
You are given two integers A and B.
Set the A-th bit and B-th bit in 0, and return output in decimal Number System.
 */
public class SetBit {
    public static int solve(int A, int B) {
        int N = 0;
        // set Ath bit in N
        N = N|(1<<A);
        // set Bth bit in N
        N = N|(1<<B);
        return N;
    }

    public static void main(String[] args) {
        System.out.println(solve(3,5));
    }
}
