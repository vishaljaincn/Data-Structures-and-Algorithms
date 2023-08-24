package day20_Recursion_2;

/*
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).
Note: The remainders on division cannot be negative. In other words, make sure the answer you return is
non-negative.

///////////// TC - O(log N), SC - O(log N)
 */
public class Implement_Fast_Power_OR_Fast_Exponentiation_With_Modulo {
    public static int pow(int A, int B, int C) {
        // Base case: If A is 0, any power of it will be 0
        if (A == 0) {
            return 0;
        }

        // Base case: If B is 0, any number raised to the power of 0 is 1
        if (B == 0) {
            return 1;
        }

        // Recursive calculation of p, where p = A^(B/2) % C
        long p = pow(A, B / 2, C);

        // Calculate the result of (p * p) % C, which represents (A^(B/2) * A^(B/2)) % C
        long result = (p * p) % C;

        // If B is odd, multiply the result by A once more and take the modulo with C
        if (B % 2 == 1) {
            result = (result * A) % C;
        }

        // Ensure the result is non-negative by using modulo C
        result = (result + C) % C;

        // Convert the final result back to integer and return
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2,3,3));
    }
}

