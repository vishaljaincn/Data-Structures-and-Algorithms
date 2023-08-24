package primerContent;

import java.util.Scanner;

public class VowelConsonantSwitchStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> System.out.println("vowel");
            default -> System.out.println("consonant");
        }
    }
}
