package primerContent;

import java.util.Scanner;

public class TernaryOperator {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int num=scanner.nextInt();
        String ans;
        ans= num%2==0?"even":"odd";
        System.out.println(ans);
    }
}
