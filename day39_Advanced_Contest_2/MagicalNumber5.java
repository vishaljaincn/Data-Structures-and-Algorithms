package day39_Advanced_Contest_2;

/*
given a binary array, we define xi as the number whose binary representation is the sub arrayA[0...i](from most significant bit to
the least significant bit), For example, if A = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
write a function that returns an int array where answer[i] is 1 if xi is divisible by 5
Example 1:

Input: A = [0,1,1]
Output: [true,false,false]
Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
Only the first number is divisible by 5, so answer[0] is true.
Example 2:

Input: A = [1,1,1]
Output: [false,false,false]
 
Constraints:
1 <= A.length <= 10^5
A[i] is either 0 or 1.
 */
public class MagicalNumber5 {
    public int[] divisibleBy5(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int remainder = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the binary value of the current sub array A[0...i].
//            remainder = (remainder * 2 + A[i]) % 5;
            remainder = ((remainder << 1) + A[i]) % 5;

            // Check if the remainder is 0 (i.e., divisible by 5).
            if (remainder == 0) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MagicalNumber5 solution = new MagicalNumber5();
        int[] A = {1, 0, 1, 1, 0, 1};
        int[] A2 = {0, 1, 1, 1, 1, 0};

        int[] result = solution.divisibleBy5(A);
        int[] result2 = solution.divisibleBy5(A2);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}
