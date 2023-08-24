package primerContent;

import java.util.Arrays;
import java.util.Scanner;

public class MaxAndMinElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("provide size of an array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("provide array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Maximum element in the array is " + max);
        System.out.println("Minimum element in the array is " + min);
    }
}
