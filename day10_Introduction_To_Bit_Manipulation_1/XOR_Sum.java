package day10_Introduction_To_Bit_Manipulation_1;

/*
Given two integers A and B. Find the minimum value (A ^ X) + (B ^ X) that can be achieved for any X.
 */
public class XOR_Sum {
    public static int solve(int A, int B) {
        int X = A & B;
//        Both & and | works exactly the same for this question
//        int X = A | B;

        return (A ^ X) + (B ^ X);
    }

    public static void main(String[] args) {
        int A1 = 6;
        int B1 = 12;
        System.out.println(solve(A1,B1));
        int A2 = 4;
        int B2 = 9;
        System.out.println(solve(A2,B2));
    }
}