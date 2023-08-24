package day20_Recursion_2;

public class Implement_Power_Not_Optimized_O_Of_N {
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

        // Recursive case: A^B = A^(B-1) * A
        // Recursively calculate A^(B-1) and multiply it by A
        return pow(A, B - 1) * A;
    }

    public static void main(String[] args) {
        // Calculate and print the result of 2^5
        System.out.println(pow(2, 5));
    }
}
