package day15_Intermediate_DSA_Contest2;

/*
construct a binary number having A 1's followed by B 0's.
Return the decimal value of that binary number,

Constraints : 1<=A+B<=30
 */
public class ConstructBinaryNumber {
    public static int solve(int A, int B) {
//        Take initial number as 0
        int num = 0;
//         Construct the binary number with A 1's
        for (int i = 0; i < A; i++) {
            num = num | (1 << i); //Set the ith bit to 1
        }
//        Shift the binary number left by B positions to add B 0's at the end
        num = num << B;
        return num;
    }

    public static void main(String[] args) {

        System.out.println(solve(3, 2));
    }
}
