package primerContent;

import java.util.Arrays;

public class SquareOfANumber {
    static int square(int num)
    {
        return num*num;
    }

    public static void main(String[] args) {
        int no=4;
        int sq=square(no);
        System.out.println(sq);
        String [] arr={"hi","Hello","bitch"};
        System.out.println(Arrays.toString(arr));
        String s=3+5+"hiiiii"+5;
        System.out.println(s);
        int arrxp[]={1,2,3,3,4,4,4};
        String sx="boli"+Arrays.toString(arrxp);
        System.out.println(sx);
    }
}
