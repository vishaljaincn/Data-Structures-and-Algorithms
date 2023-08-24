package day16_Strings;

/*
Given two binary strings A and B. Return their sum (also a binary string).
Example Input
Input 1:
A = "100"
B = "11"
Input 2:
A = "110"
B = "10"

Example Output
Output 1:
"111"
Output 2:
"1000"
 */
public class AddBinaryStrings {
    public String addBinary(String A, String B) {
        StringBuilder result = new StringBuilder(); // Create a StringBuilder to store the result
        int carry = 0; // Initialize the carry to 0

        int i = A.length() - 1; // Start from the rightmost digit of A
        int j = B.length() - 1; // Start from the rightmost digit of B
        while (i >= 0 || j >= 0) { // Continue until both strings are fully processed
            int digitA = 0;
            int digitB = 0;

            if (i >= 0) {
                digitA = A.charAt(i) - '0'; // Convert the character to an integer (0 or 1)
            }
            if (j >= 0) {
                digitB = B.charAt(j) - '0'; // Convert the character to an integer (0 or 1)
            }

            int sum = digitA + digitB + carry; // Calculate the sum of the current digits and carry
            carry = sum / 2; // Calculate the new carry for the next iteration
            result.append(sum % 2); // Append the least significant bit of the sum to the result

            i--; // Move to the next digit of A
            j--; // Move to the next digit of B
        }

        if (carry > 0) {
            result.append(carry); // Append the final carry if it's greater than 0
        }

        return result.reverse().toString(); // Reverse the result and convert it to a string
    }

    public static void main(String[] args) {
        AddBinaryStrings solution = new AddBinaryStrings();

        String A1 = "100";
        String B1 = "11";
        System.out.println(solution.addBinary(A1, B1)); // Output: "111"

        String A2 = "110";
        String B2 = "10";
        System.out.println(solution.addBinary(A2, B2)); // Output: "1000"
    }
}

