package primerContent;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("please enter an input string");
        String str=scanner.nextLine();
        int i=0, j=str.length()-1;
        while(i<j)
        {
            if(!(str.charAt(i)==str.charAt(j)))
            {
                System.out.println("not palindrome");
                return;
            }
            i++;
            j--;
        }
        System.out.println("palindrome");
    }
}
