package day16_Strings;

/*
Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
 */
public class CountOccurrences {
    public static int solve(String A) {
        int count = 0;
        int n = A.length();

        // Traverse the string and check for occurrences of "bob"
        for (int i = 0; i < n - 2; i++) {
            if (A.charAt(i) == 'b' && A.charAt(i + 1) == 'o' && A.charAt(i + 2) == 'b') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String S="bobob";
        System.out.println(solve(S));
    }
}
