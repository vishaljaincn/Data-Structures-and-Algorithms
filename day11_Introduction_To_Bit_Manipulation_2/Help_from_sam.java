package day11_Introduction_To_Bit_Manipulation_2;

/*
Alex and Sam are good friends. Alex is doing a lot of programming these days. He has set a target score of A for himself.
Initially, Alex's score was zero. Alex can double his score by doing a question, or Alex can seek help from Sam for
doing questions that will contribute 1 to Alex's score. Alex wants his score to be precisely A. Also, he does not want to
take much help from Sam.

Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of A.

Problem Constraints
0 <= A <= 10^9
 */
public class Help_from_sam {
    public static int solve(int A) {
        int count = 0;
        // Edge case
        if (A == 0) {
            return 0;
        }
        // To count the number of bits set to 1
        while (A > 0) {
            if ((A & 1) == 1) {
                count++;
            }
            A = A >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(5));
    }
}
