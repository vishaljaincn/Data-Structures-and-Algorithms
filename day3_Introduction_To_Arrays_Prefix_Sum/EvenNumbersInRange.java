package day3_Introduction_To_Arrays_Prefix_Sum;

import java.util.Arrays;

public class EvenNumbersInRange {
    public int[] solve(int[] A, int[][] B) {

        int N=A.length;
        //Step 1 modify current array to even and odd array
        for(int i=0; i<N; i++){
            if(A[i]%2==0){
                A[i]=1;
            }else
                A[i]=0;
        }
        //step2: modify or create new array using prefix sum logic
        for(int i=1; i<N; i++){
            A[i]=A[i-1]+A[i];
        }

        int count=0;
        int Q=B.length;
        int ans[]= new int[Q];

        //Step 3: Iterate over given range in B array and add count to ans[] array and return
        for(int j=0; j<Q; j++){
            int startIndex=B[j][0];
            int endIndex=B[j][1];
            if(startIndex==0){
                ans[j]=A[endIndex];
            }else{
                ans[j]=A[endIndex]-A[startIndex-1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EvenNumbersInRange evenNumbersInRange = new EvenNumbersInRange();

        // Test case 1
        int[] A1 = {1, 2, 3, 4, 5};
        int[][] B1 = {{0, 2}, {2, 4}, {1, 4}};
        int[] result1 = evenNumbersInRange.solve(A1, B1);
        System.out.println(Arrays.toString(result1)); // Output: [1, 1, 2]

        // Test case 2
        int[] A2 = {2, 1, 8, 3, 9, 6};
        int[][] B2 = {{0, 3}, {3, 5}, {1, 3}, {2, 4}};
        int[] result2 = evenNumbersInRange.solve(A2, B2);
        System.out.println(Arrays.toString(result2)); // Output: [2, 1, 1, 1]

    }
}
