package primerContent;

import java.util.ArrayList;
import java.util.Scanner;

public class TransposeOfA2DArrayList {
    public static void main(String[] args) {
//        Reading a 2D Arraylist
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the no of arraylist you want to put it in a 2D Arraylist");
        int a = scanner.nextInt();
        ArrayList<ArrayList<Integer>> arrMain = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < a; i++) {
            System.out.println("Enter the size of actual inside arrayList");
            int b = scanner.nextInt();
            ArrayList<Integer> arrInside = new ArrayList<>();
            for (int j = 0; j < b; j++) {
                arrInside.add(scanner.nextInt());
            }
            arrMain.add(arrInside);
        }
        System.out.println(arrMain);
//        Transpose of a 2D Arraylist
        ArrayList<ArrayList<Integer>> trans = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<arrMain.get(0).size();i++)
        {
            ArrayList<Integer> arrInside = new ArrayList<>();
            for(int j=0;j<arrMain.size();j++)
            {
                arrInside.add(arrMain.get(j).get(i));
            }
            trans.add(arrInside);
        }
        System.out.println(trans);
    }
}
