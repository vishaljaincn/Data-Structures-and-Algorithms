package day12_Maths_Modular_Arithmetic_Introduction;

public class Divisibility_By_8 {
    public static int solve(String A) {
        int n = A.length();
//        Edge cases
        if (n == 1 || n == 2) {
            if (Integer.parseInt(A) % 8 == 0) {
                return 1;
            } else {
                return 0;
            }
        }

//      Integer.parseInt(String S) method is used to convert String(containing only integers) to primitive int datatype
        int lastThreeDigits = Integer.parseInt(A.substring(n - 3));
        if (lastThreeDigits % 8 == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solve("808144"));
    }
}
