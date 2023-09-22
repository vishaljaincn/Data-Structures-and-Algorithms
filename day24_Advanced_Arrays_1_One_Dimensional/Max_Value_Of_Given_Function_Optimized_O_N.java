package day24_Advanced_Arrays_1_One_Dimensional;

/*
java program to find maximum value of |arr[i] - arr[j]| + |i - j|
REFER CLASS NOTES PAGE 8
 */
public class Max_Value_Of_Given_Function_Optimized_O_N {
    public static int findValue(int A[]) {
        int n = A.length;
        int temp1, temp2;
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            temp1 = A[i] + i;
            temp2 = A[i] - i;
            max1 = Math.max(max1, temp1);
            min1 = Math.min(min1, temp1);
            max2 = Math.max(max2, temp2);
            min2 = Math.min(min2, temp2);
        }
        return Math.max((max1 - min1), (max2 - min2));
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        System.out.println(findValue(arr));
    }
}
