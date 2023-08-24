package primerContent;

import java.util.Scanner;

public class GCF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		scanner.close();
		int t,gcd = 0;
		if (x < y) {
			t = x;
		} else {
			t = y;
		}

		for (int i = 1; i <= t; i++) {
			if (x % i == 0 && y%i==0) {
				 gcd=i;
			}
		}
		System.out.println(gcd);

	}

}
