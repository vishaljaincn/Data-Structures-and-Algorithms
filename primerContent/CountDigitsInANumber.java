package primerContent;

import java.util.Scanner;

public class CountDigitsInANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /*Extra
        double f =9/4.0;
        System.out.println(f);
        double d=9%4.0;
        System.out.println(d);
        */
        int num = scanner.nextInt();
        int count = 0;
        while (num > 0) {
//            int rem=num%10;
//            if (rem >= 0) {
//                count++;
//            }
            count++;
            num = num / 10;
        }
        System.out.println(count);
    }
}
