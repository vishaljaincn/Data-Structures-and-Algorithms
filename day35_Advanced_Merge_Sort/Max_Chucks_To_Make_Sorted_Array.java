package day35_Advanced_Merge_Sort;
/* The smallest leftmost possible chunk is the smallest index at which A[0….i] contains all elements up to i.
We can check that if a maximum of A[0…..i] is i, then we can take it as a separate chunk.
Find the smallest possible leftmost chunk using the above idea, and after that, we can proceed similarly for the remaining part.*/

public class Max_Chucks_To_Make_Sorted_Array {
    public int solve(int[] A) {
        int n = A.length;
        int chunkCount = 0; // To count the number of chunks
        int maxElement = 0; // To keep track of the maximum element encountered so far

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Update the maximum element encountered
            maxElement = Math.max(maxElement, A[i]);

            // If the maximum element equals the current index, it's a valid chunk
            if (maxElement == i) {
                chunkCount++;
            }
        }

        return chunkCount;
    }
}
