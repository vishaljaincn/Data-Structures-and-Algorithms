package day11_Introduction_To_Bit_Manipulation_2;

/*
Write a function that takes an integer and returns the number of 1 bits present in its binary representation.
 */
public class NumberOf_1_Bits {
    public static int numSetBits(int A) {
        // // TC and SC -> O(1)
        // int count=0;
        // for(int i=0;i<32;i++)
        // {
        //     if((A&(1<<i))==(1<<i))
        //     {
        //         count++;
        //     }
        // }
        // return count;

        // // for huge numbers, more than long above 10^18 bits we can use below method
        // TC -> O(log N)
        int count = 0;
        while (A > 0) {
//            checking last/0th bit is 1 or not if((A & 1<<0) == (1<<0)) or just if ((A & 1) == 1)
            if ((A & 1) == 1) {
                count++;
            }
            A = (A >> 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSetBits(11));
    }
}
