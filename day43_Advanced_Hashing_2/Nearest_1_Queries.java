package day43_Advanced_Hashing_2;

import java.util.TreeSet;

/*
given a binary array and 2 types of queries,
1) [1,X] - flip the character at X
2) [2,X] - find the index of 1 nearest to X, if left and right both are same, print left
 */

public class Nearest_1_Queries {
    ///T C - O(Q * log n)
    public static void solve(int A[], int Q[][]) {
        TreeSet<Integer> ts = new TreeSet<>();

        // Initialize the TreeSet with the indices of 1s in the binary array
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                ts.add(i);
            }
        }

        for (int[] query : Q) {
            int type = query[0];
            int index = query[1];

            if (type == 1) {
                // Type 1: Flip the character at index X
                if (A[index] == 1) {
                    // If A[x] is 1, remove the index from the TreeSet and set A[x] to 0
                    ts.remove(index);
                    A[index] = 0;
                } else {
                    // If A[x] is 0, add the index to the TreeSet and set A[x] to 1
                    ts.add(index);
                    A[index] = 1;
                }
            } else if (type == 2) {
                // Type 2: Find the index of 1 nearest to X
                Integer left = ts.lower(index);    // Get the index of the nearest 1 to the left of X
                Integer right = ts.higher(index);  // Get the index of the nearest 1 to the right of X

                if (left == null && right == null) {
                    System.out.println(-1); // No 1 found
                } else if (left == null) {
                    System.out.println(right);  // Only a right nearest 1
                } else if (right == null) {
                    System.out.println(left);   // Only a left nearest 1
                } else {
                    int leftDistance = index - left;     // Distance to the left nearest 1
                    int rightDistance = right - index;   // Distance to the right nearest 1

                    if (leftDistance <= rightDistance) {
                        System.out.println(left);  // Left nearest 1 is closer
                    } else {
                        System.out.println(right); // Right nearest 1 is closer
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] binaryArray = {0, 1, 0, 0, 1};
        int[][] queries = {{1, 2}, {2, 3}, {1, 0}, {2, 4}};

        solve(binaryArray, queries);
    }
}

