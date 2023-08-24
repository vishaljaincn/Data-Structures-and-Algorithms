package day3_Introduction_To_Arrays_Prefix_Sum;

import java.util.ArrayList;

public class RangeSumQuery {
        public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
            int n = A.size();
            // Create a prefix sum array of Long
            ArrayList<Long> prefixSum = new ArrayList<>(n);
            prefixSum.add(A.get(0).longValue());

            for (int i = 1; i < n; i++) {
                long sum = prefixSum.get(i - 1) + A.get(i);
                prefixSum.add(sum);
            }

            ArrayList<Long> arr = new ArrayList<>();
            int x = B.size();
            for (int i = 0; i < x; i++) {
                int a = B.get(i).get(0);
                int b = B.get(i).get(1);

                long sum;
                if (a == 0) {
                    sum = prefixSum.get(b);
                } else {
                    sum = prefixSum.get(b) - prefixSum.get(a - 1);
                }
                arr.add(sum);
            }
            return arr;
        }

        public static void main(String[] args) {
            RangeSumQuery rangeSumQuery = new RangeSumQuery();

            ArrayList<Integer> A1 = new ArrayList<>();
            A1.add(1);
            A1.add(2);
            A1.add(3);
            A1.add(4);
            A1.add(5);

            ArrayList<ArrayList<Integer>> B1 = new ArrayList<>();
            ArrayList<Integer> query1 = new ArrayList<>();
            query1.add(0);
            query1.add(3);
            B1.add(query1);
            ArrayList<Integer> query2 = new ArrayList<>();
            query2.add(1);
            query2.add(2);
            B1.add(query2);

            System.out.println(rangeSumQuery.rangeSum(A1, B1)); // Output: [10, 5]

            ArrayList<Integer> A2 = new ArrayList<>();
            A2.add(2);
            A2.add(2);
            A2.add(2);

            ArrayList<ArrayList<Integer>> B2 = new ArrayList<>();
            ArrayList<Integer> query3 = new ArrayList<>();
            query3.add(0);
            query3.add(0);
            B2.add(query3);
            ArrayList<Integer> query4 = new ArrayList<>();
            query4.add(1);
            query4.add(2);
            B2.add(query4);

            System.out.println(rangeSumQuery.rangeSum(A2, B2)); // Output: [2, 4]
        }
    }

