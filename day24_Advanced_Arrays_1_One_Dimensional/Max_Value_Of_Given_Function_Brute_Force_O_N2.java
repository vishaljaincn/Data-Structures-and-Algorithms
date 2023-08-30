package day24_Advanced_Arrays_1_One_Dimensional;

/*
java program to find maximum value of |arr[i] - arr[j]| + |i - j|
 */
public class Max_Value_Of_Given_Function_Brute_Force_O_N2 {
    public static int findValue(int A[]) {
        int n = A.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, (Math.abs(A[i] - A[j]) + Math.abs(i - j)));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        System.out.println(findValue(arr));
    }
}
