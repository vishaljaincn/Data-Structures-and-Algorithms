package primerContent;

import java.util.Arrays;
import java.util.Scanner;

public class StringEx {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = "def";
        s2 = "hello world";
        s3 = "gandu";
        char c='x';
        System.out.println(s2);
        System.out.println(s3);
        s1 = s1.concat("Tendulkar");
        System.out.println(s1);
        System.out.println(s1.indexOf("abc"));
        System.out.println("hello".length());
        System.out.println("hello".toUpperCase());
        System.out.println(s1.contains("ab"));
        String s4 = s1 + 5+"bitch"+"ran";
        System.out.println(s4);
        int arr[]={1,2,3,4,};
        System.out.println(Arrays.toString(arr) +" hi bitch");
        int[][]arr1={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(arr1));
        Scanner scanner=new Scanner(System.in);
        String str= scanner.nextLine();

        for(int i=str.length()-1;i>=0;i--)
        {
            System.out.print(str.charAt(i));
        }


    }
}
