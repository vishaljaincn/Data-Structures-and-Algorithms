package day14_Interview_Problems;

/*
There are A people standing in a circle. Person 1 kills their immediate clockwise neighbour and pass the
knife to the next person standing in circle. This process continues until there is only 1 person remaining.
Find the last person standing in the circle.
 */
public class JosephusProblemSolver {
    public static int findLastPersonStanding(int A) {
        // If the number of people is a power of 2, only the first person will survive.
        if ((A & (A - 1)) == 0) {
            return 1;
        }

        int closestPowerOf2 = 1;
        while (closestPowerOf2 < A) {
            closestPowerOf2 = closestPowerOf2 * 2;
            if (closestPowerOf2 > A) {
                closestPowerOf2 = closestPowerOf2 / 2;
                break;
            }
        }

        // The position of the last person standing can be calculated using this formula.
        return 1 + (A - closestPowerOf2) * 2;
    }

    public static void main(String[] args) {
        System.out.println("Last person standing for 4 people: " + findLastPersonStanding(4));
        System.out.println("Last person standing for 5 people: " + findLastPersonStanding(5));
    }
}
