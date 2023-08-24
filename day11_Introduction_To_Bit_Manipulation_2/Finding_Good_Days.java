package day11_Introduction_To_Bit_Manipulation_2;

/*
Alex has a cat named Boomer. He decides to put his cat to the test for eternity.

He starts on day 1 with one stash of food unit, every next day, the stash doubles.

If Boomer is well behaved during a particular day, only then she receives food worth equal to the stash produced on
that day.

Boomer receives a net worth of A units of food. What is the number of days she received the stash?

Problem Constraints
1 <= A <= 231-1
 */
public class Finding_Good_Days {
    public static int solve(int A) {
        int count = 0;
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
        System.out.println(solve(8));
    }
}
