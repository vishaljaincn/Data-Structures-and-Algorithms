package primerContent;

import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int principle= scanner.nextInt();;
        int rate=scanner.nextInt();
        int time=scanner.nextInt();
        int simpleInterest=(principle*rate*time)/100;
        System.out.println(simpleInterest);
    }
}
