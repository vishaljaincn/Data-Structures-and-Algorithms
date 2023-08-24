package primerContent;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class LargestOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int max=Integer.MIN_VALUE;
        for (int i = 1; i <= num; i++) {
            int temp = scanner.nextInt();
            max=Math.max(max,temp);
//            if (temp > max) {
//                max = temp;
//            }
        }
        System.out.println(max);
    }
}
