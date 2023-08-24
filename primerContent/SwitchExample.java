package primerContent;

import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        switch (month) {
            case 1 -> {
                System.out.println("january");
                System.out.println("hi");
            }
            case 2 -> {
                System.out.println("february");
                System.out.println("hi");
            }
            case 3 ->
                System.out.println("march");

            case 4 -> {
                System.out.println("april");
                System.out.println("hi");
            }
            case 5 -> {
                System.out.println("may");
                System.out.println("hi");
            }
            case 6 -> {
                System.out.println("june");
                System.out.println("hi");
            }
            case 7 -> {
                System.out.println("july");
                System.out.println("hi");
            }
            case 8 -> {
                System.out.println("august");
                System.out.println("hi");
            }
            case 9 -> {
                System.out.println("september");
                System.out.println("hi");
            }
            case 10 -> {
                System.out.println("october");
                System.out.println("hi");
            }
            case 11 -> {
                System.out.println("november");
                System.out.println("hi");
            }
            case 12 -> {
                System.out.println("december");
                System.out.println("hi");
            }
            default -> {
                System.out.println("invalid month no entered");
                System.out.println("hi");
            }
        }

    }

}

