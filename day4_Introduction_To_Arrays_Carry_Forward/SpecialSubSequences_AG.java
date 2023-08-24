package day4_Introduction_To_Arrays_Carry_Forward;
/*
Problem Description
You have given a string A having Uppercase English letters.
You have to find how many times subsequence "AG" is there in the given string.
NOTE: Return the answer modulo 109 + 7 as the answer can be very large.

Problem Constraints
1 <= length(A) <= 105

Input Format
First and only argument is a string A.

Output Format
Return an integer denoting the answer.

Example Input
Input 1:

 A = "ABCGAG"
Input 2:

 A = "GAB"

Example Output
Output 1:
 3
Output 2:
 0
Example Explanation
Explanation 1:
 Subsequence "AG" is 3 times in given string
Explanation 2:
 There is no subsequence "AG" in the given string.
 */
public class SpecialSubSequences_AG {
    public int solve(String A) {
        int Gcount=0,A_Gcount=0;
        int modulo=(int)Math.pow(10,9)+7;
        for(int i=A.length()-1;i>=0;i--){
            if(A.charAt(i)=='G'){
                Gcount++;
            }else if(A.charAt(i)=='A'){
                A_Gcount=(A_Gcount+Gcount)%modulo;
            }
        }
        return A_Gcount;
    }

    public static void main(String[] args) {
        SpecialSubSequences_AG specialSubSequencesAg=new SpecialSubSequences_AG();
        System.out.println(specialSubSequencesAg.solve("ABCGAG"));
    }
}
