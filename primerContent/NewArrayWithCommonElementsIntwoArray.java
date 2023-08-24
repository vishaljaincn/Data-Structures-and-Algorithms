package primerContent;

import java.util.Scanner;

public class NewArrayWithCommonElementsIntwoArray {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter Size of First Array");
        int n=scanner.nextInt();
        System.out.println("Enter size of Second Array");
        int m=scanner.nextInt();
        int [] arr1=new int[n];
        int [] arr2=new int[m];
        System.out.println("Enter elements of 1st array");
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i]=scanner.nextInt();
        }
        System.out.println("Enter elements of 2nd array");
        for(int j=0;j<arr2.length;j++)
        {
            arr2[j]=scanner.nextInt();
        }
        int count=0;
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr2.length;j++)
            {
                if(arr1[i]==arr2[j])
                {
                    count++;
                }
            }
        }
        int arr3[]=new int[count];
        int x=0;
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr2.length;j++)
            {
                if(arr1[i]==arr2[j])
                {
                    arr3[x]=arr1[i];
                    x++;
                }
            }
        }
        System.out.println("Common elements in both the array");
       for(int i=0;i<arr3.length;i++)
       {
           System.out.println(arr3[i]);
       }
    }
}
