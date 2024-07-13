package leetcode_Extra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


class Sort_Array_by_Increasing_Frequency_1636 {
    public int[] frequencySort(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Fill the hashmap with frequency counts
        for (int i = 0; i < n; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }

        // Convert int[] to Integer[] for sorting with Comparator
        Integer[] array = Arrays.stream(A).boxed().toArray(Integer[]::new);

        // Sort the array based on frequency and value
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int x = hm.get(a);
                int y = hm.get(b);
                if (x < y) {
                    return -1;
                } else if (x > y) {
                    return 1;
                } else {
                    return Integer.compare(b, a); // For same frequency, sort by descending value
                }
            }
        });

        // Convert Integer[] back to int[]
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }
}
