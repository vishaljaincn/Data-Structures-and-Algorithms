package day16_Strings;

public class Solution {
    public static int solve(String A) {
        int longestLength =0;
        int n=A.length();
        for(int i=0;i<n;i++){
            int lengthOdd=expand(A,i,i);
            longestLength=Math.max(longestLength, lengthOdd);
        }
        for(int i=0;i<n-1;i++){
            int lengthEven=expand(A,i,i+1);
            longestLength=Math.max(longestLength, lengthEven);
        }
        return longestLength;
    }
    public static int expand(String A, int c1, int c2){
        int p1=c1;
        int p2=c2;
        int n=A.length();
        while(p1>=0 && p2<n && A.charAt(p1)==A.charAt(p2)){
            p1--;
            p2++;
        }
        return p2-p1-1;
    }

    public static void main(String[] args) {
        String S="dccbcdaac";
        System.out.println(solve(S));
    }
}
