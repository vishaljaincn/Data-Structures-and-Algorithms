package primerContent;

import java.util.ArrayList;

public class IdentityMatrix2DArrayList {
    public static ArrayList<ArrayList<Integer>> identity(int n)
    {
        ArrayList<ArrayList<Integer>> aout=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> ain=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    ain.add(1);
                }
                else
                {
                    ain.add(0);
                }
            }
            aout.add(ain);
        }
        return aout;
    }
    public static void main(String[] args) {
        System.out.println(identity(4));
    }
}
