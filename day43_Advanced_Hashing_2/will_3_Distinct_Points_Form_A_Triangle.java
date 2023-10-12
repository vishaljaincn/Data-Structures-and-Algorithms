package day43_Advanced_Hashing_2;

/*
given 3 distinct points in a 2d plane, check if they form triangle, such that shorter sides are parallel to x-axis and y-axis,
write code in java using O(1)time complexity and O(1) space complexity
 */
public class will_3_Distinct_Points_Form_A_Triangle {
    public static boolean solve(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Assume A(1st point) is at 90-degree
        if ((x1 == x3 && y1 == y2) || (x1 == x2 && y1 == y3)) {
            return true;
        }
        // Assume B(2nd point) is at 90-degree
        else if ((x2 == x3 && y2 == y1) || (x2 == x1 && y2 == y3)) {
            return true;
        }
        // Assume C(3rd point) is at 90-degree
        else if ((x3 == x1 && y3 == y2) || (x3 == x2 && y3 == y1)) {
            return true;
        }
        // If none of the conditions above is met, it is not a triangle as described.
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(3, 2, 3, 4, 5, 2));
    }
}