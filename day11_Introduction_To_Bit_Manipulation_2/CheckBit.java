package day11_Introduction_To_Bit_Manipulation_2;
/*
You are given two integers A and B.
Return 1 if B-th bit in A is set
Return 0 if B-th bit in A is unset
Note:
The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.
 */
public class CheckBit {
    public static int solve(int A, int B) {
        // Checking if the bit is set or not
        if((A & (1<<B)) == (1<<B))
        {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solve(5,2));
    }
}
