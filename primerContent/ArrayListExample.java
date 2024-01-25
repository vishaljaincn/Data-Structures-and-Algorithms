package primerContent;

import java.util.ArrayList;
import java.util.Arrays;
//
public class ArrayListExample {
    public static int sum(ArrayList<Integer> arr)
    {
        int sum=0;
        for(int i=0;i<arr.size();i++)
        {
            sum=sum+arr.get(i);
        }
        return sum;
    }
    public static ArrayList<Integer> positive(ArrayList<Integer> arr)
    {
         ArrayList<Integer> posarr=new ArrayList<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)>0)
            {
                posarr.add(arr.get(i));
            }
        }
        return posarr;
    }
    public static void isSorted(ArrayList<Integer> arr)
    {
        for(int i=0;i<arr.size()-1;i++)
        {
            if(!(arr.get(i)<=arr.get(i+1)))
            {
                System.out.println("not sorted");
                return;
            }
        }
        System.out.println("sorted");
    }
    public static ArrayList<Integer> onlyOnce(ArrayList<Integer> arr)
    {
        ArrayList<Integer> aronly=new ArrayList<>();
        for(int i=0;i<arr.size();i++)
        {
            int count=0;
            for(int j=0;j<arr.size();j++)
            {
                if(i==j)
                {
                    continue;
                }
                if(arr.get(i)==arr.get(j)) {
                    count++;
                }
            }
            if(count==0)
            {
                aronly.add(arr.get(i));
            }
        }
        return aronly;
    }
    public static void main(String[] args) {
        ArrayList<Integer>arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(-9);
        System.out.println(arr);
        System.out.println(arr.get(0));
        System.out.println(arr.size());
        arr.set(1,50);
        System.out.println(arr);
        int ans=sum(arr);
        System.out.println(ans);
        System.out.println(positive(arr));
        isSorted(arr);
        ArrayList<Integer>arr2=new ArrayList<>();
        for(int i=1;i<=7;i++)
        {
            arr2.add(i);
        }
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(7);
        System.out.println(arr2);
        isSorted(arr2);
        System.out.println(onlyOnce(arr2));

    }
}
