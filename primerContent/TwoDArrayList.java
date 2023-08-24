  package primerContent;

import java.util.ArrayList;
import java.util.Scanner;

  public class TwoDArrayList {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<ArrayList<Integer>>mat=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> al1=new ArrayList<>();
        al1.add(1);
        al1.add(-23);
        mat.add(al1);
        System.out.println(mat);
        ArrayList<Integer> al2=new ArrayList<>();
        al2.add(1);
        al2.add(19);
        mat.add(al2);
        System.out.println(mat);
        ArrayList<Integer> al3=new ArrayList<>();
        al3.add(1);
        al3.add(-23);
        al3.add(19);
        mat.add(al3);
        System.out.println(mat);
//        Taking input from the user to a 2D Arraylist
        System.out.println("enter the no of arraylist you want to put it in a 2D Arraylist");
        int a=scanner.nextInt();
        ArrayList<ArrayList<Integer>>arrMain=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a;i++)
        {
            System.out.println("Enter the size of actual inside arrayList");
            int b=scanner.nextInt();
            ArrayList<Integer> arrInside=new ArrayList<>();
            for(int j=0;j<b;j++)
            {
                arrInside.add(scanner.nextInt());
            }
            arrMain.add(arrInside);
        }
        System.out.println(arrMain);
        System.out.println(arrMain.size());
//        printing the 2D Arraylist
        for(int i=0;i<arrMain.size();i++)
        {
            for(int j=0;j<arrMain.get(i).size();j++)
            {
                System.out.print(arrMain.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
