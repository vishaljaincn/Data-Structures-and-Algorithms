package day2_Introduction_to_arrays;

import java.util.ArrayList;

/*Given an integer array A of size N. In one second, you can increase the value of one element by 1.
Find the minimum time in seconds to make all elements of the array equal.
Example Input
A = [2, 4, 1, 3, 2]
Example Output
8
Example Explanation
We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.

*/
public class TimeToEquality {
    public static int solve(ArrayList<Integer> A) {
        int n=A.size();
        int max=A.get(0);
        for(int i=1;i<n;i++)
        {
            if(A.get(i)>max)
            {
                max=A.get(i);
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            count=count+(max-A.get(i));
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(solve(list));
    }

}
