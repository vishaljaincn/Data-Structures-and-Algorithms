package day4_Introduction_To_Arrays_Carry_Forward;
/*
A wire connects N light bulbs.

Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.

You can press the same switch multiple times.

Note: 0 represents the bulb is off and 1 represents the bulb is on.
 */
public class Bulbs {
    public static int bulbs(int[] A) {
        int n = A.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(A[i] == 0 && count % 2 == 0) {
                count++;
            }
            if(A[i] == 1 && count % 2 == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[]={0, 1, 0, 1};
        System.out.println(bulbs(arr));
    }
}
