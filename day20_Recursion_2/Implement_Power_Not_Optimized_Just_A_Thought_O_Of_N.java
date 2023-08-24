package day20_Recursion_2;

public class Implement_Power_Not_Optimized_Just_A_Thought_O_Of_N {
    // Recursive function to calculate A^B
    public static int pow(int A, int B) {
        // Base case: If A is 0, any power of it will be 0
        if (A == 0) {
            return 0;
        }

        // Base case: If B is 0, any number raised to the power of 0 is 1
        if (B == 0) {
            return 1;
        }

        // If B is even, divide B by 2 and calculate A^(B/2) * A^(B/2)
        if (B % 2 == 0) {
            return pow(A, B / 2) * pow(A, B / 2);
        }
        // If B is odd, divide B by 2 and calculate A^(B/2) * A^(B/2) * A
        else {
            return pow(A, B / 2) * pow(A, B / 2) * A;
        }
    }

    public static void main(String[] args) {
        // Calculate and print the result of 2^5
        System.out.println(pow(2, 5));
    }
}
