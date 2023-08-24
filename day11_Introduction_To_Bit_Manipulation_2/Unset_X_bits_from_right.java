package day11_Introduction_To_Bit_Manipulation_2;

/*
Given an integer A. Unset B bits from the right of A in binary.

For example, if A = 93 and B = 4, the binary representation of A is 1011101.
If we unset the rightmost 4 bits, we get the binary number 1010000, which is equal to the decimal value 80.
 */
public class Unset_X_bits_from_right {
    public static long solve(long A, int B) {
        for (int i = 0; i < B; i++) {
            // Checking if the bit is set or not
            if ((A & (1 << i)) == (1 << i)) {
                // Unset it if the bit is set
                A = A ^ (1 << i);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(solve(25,3));
    }
}
