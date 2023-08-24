package day20_Recursion_2;

/*
Implement pow(A, B) .
In other words, given A, B , Find (A^B ).

///////////// TC - O(log N), SC - O(log N)
 */
public class Implement_Fast_Power_OR_Fast_Exponentiation {
    public static int pow(int A, int B) {
        // Base case: If A is 0, any power of it will be 0
        if (A == 0) {
            return 0;
        }

        // Base case: If B is 0, any number raised to the power of 0 is 1
        if (B == 0) {
            return 1;
        }

        // Recursive calculation of p, where p = A^(B/2)
        long p = pow(A, B / 2);

        // Calculate the result of (p * p), which represents (A^(B/2) * A^(B/2))
        long result = p * p;

        // If B is odd, multiply the result by A once more
        if (B % 2 == 1) {
            result = result * A;
        }

        // Convert the final result back to integer and return
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 3));
    }
}

