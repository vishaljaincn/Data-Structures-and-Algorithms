package primerContent;

import java.util.Arrays;
import java.util.Scanner;

public class GenerateReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("provide size of an array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("provide array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int [] arr2=new int[n];
        int x=0;
        for(int i=n-1;i>=0;i--)
        {
            arr2[x]=arr[i];
            x++;
        }
        System.out.println(Arrays.toString(arr2));
    }
}
