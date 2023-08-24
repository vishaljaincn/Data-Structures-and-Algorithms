package day16_Strings;
/*
You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.

You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.

 */
public class ToggleCase {
    public static String toggle1(String A) {
        int n = A.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char) (ch + 32)); // Convert uppercase to lowercase
            } else {
                result.append((char) (ch - 32)); // Convert lowercase to uppercase
            }
        }
        return result.toString();
    }

    public static String toggle2(String A) {
        char[] C = A.toCharArray();
        int n = C.length;
        for (int i = 0; i < n; i++) {
            if (C[i] >= 'A' && C[i] <= 'Z') {
                C[i] = (char) (C[i] + 32);
            } else {
                C[i] = (char) (C[i] - 32);
            }
        }
        return String.valueOf(C);
    }
    public static String toggle3(String A) {
        char[] C = A.toCharArray();
        int n = C.length;
        for (int i = 0; i < n; i++) {
            C[i]=(char) (C[i]^32);
//            C[i]=(char) (C[i]^(1<<5));
        }
        return String.valueOf(C);
    }

    public static void main(String[] args) {
        String S1="AnaCOndA";
        String S2="AnaCOndA";
        String S3="AnaCOndA";
        System.out.println(toggle1(S1));
        System.out.println(toggle2(S2));
        System.out.println(toggle3(S3));
    }
}
