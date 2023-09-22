package day33_Advanced_Modular_Arithmetic;

import java.util.HashMap;

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rem = A[i] % B;
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);
        }
        long totalCount = 0;
        if (hm.containsKey(0)) {
            int x = hm.get(0);
            totalCount += x*(x - 1) / 2;
        }
        if (B % 2 == 0) {
            int x = hm.get(B / 2);
            totalCount += x*(x - 1) / 2;
        }
        int i = 1, j = B - 1;
        while (i < j) {
            totalCount += hm.get(i) * hm.get(j);
            i++;
            j--;
        }
        return (int) totalCount;
    }
}
