package primerContent;

import java.util.Arrays;

public class TwoDArray {
    public static void main(String[] args) {
        int[][]a={{1,2,3},{3,2,1},{4,5,6},{6,5,4}};
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.deepToString(a));
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
