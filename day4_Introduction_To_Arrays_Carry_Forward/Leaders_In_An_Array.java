package day4_Introduction_To_Arrays_Carry_Forward;

/*
        Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.

        NOTE: The rightmost element is always a leader.


        Problem Constraints
        1 <= N <= 105
        1 <= A[i] <= 108


        Input Format
        There is a single input argument which a integer array A


        Output Format
        Return an integer array denoting all the leader elements of the array.


        Example Input
        Input 1:
        A = [16, 17, 4, 3, 5, 2]
        Input 2:
        A = [5, 4]


        Example Output
        Output 1:
        [17, 2, 5]
        Output 2:
        [5, 4]

 */
public class Leaders_In_An_Array {
    public int[] leaders_In_An_Array(int[] A) {
        int n = A.length;
        int max = A[n - 1];
        int count = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
                count++;
            }
        }
        int[] leaders = new int[count];
        max = A[n - 1];
        leaders[0] = max;
        int j = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
                leaders[j] = max;
                j++;
            }
        }
        return leaders;
    }
    /*
    //Using Arraylist with a single loop
     public ArrayList<Integer> solve(ArrayList<Integer> A) {
             int n=A.size();
             ArrayList<Integer> leaders=new ArrayList<>();
             leaders.add(A.get(n-1));
                int max=A.get(n-1);
             for (int i=n-2;i>=0;i--){
                 if(A.get(i)>max){
                     max=A.get(i);
                    leaders.add(max);
                 }
             }
             return leaders;
    }
     */

    public static void main(String[] args) {
        Leaders_In_An_Array leadersObject = new Leaders_In_An_Array();

        int[] inputArray = {16, 17, 4, 3, 5, 2};
        int[] leadersArray = leadersObject.leaders_In_An_Array(inputArray);

        System.out.println("Leaders in the array are:");
        for (int leader : leadersArray) {
            System.out.print(leader + " ");
        }
    }
}


/* Time Complexity = O(n)
Space Complexity = O(n) //bcz on new array created
*/



