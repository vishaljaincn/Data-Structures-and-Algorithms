package day64_Advanced_Heaps_1;

import java.util.PriorityQueue;
/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.

Example 1:
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

Example 2:
Input: stones = [1]
Output: 1
 */

// Time complexity: O(n log n), where n is the number of stones.
// Space complexity: O(n), for the max heap storing the stones.

public class LastStoneWeight_1046 {

    public int lastStoneWeight(int[] stones) {
        // Use a max heap to keep track of the heaviest stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all stones to the max heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Perform smashing until there is at most one stone left
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Get the heaviest stone
            int x = maxHeap.poll(); // Get the second heaviest stone

            if (x != y) {
                maxHeap.offer(y - x); // Smash and add the remaining weight
            }
            // If x == y, both stones are destroyed, and nothing is added back to the heap
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
