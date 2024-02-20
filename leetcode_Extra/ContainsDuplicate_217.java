package leetcode_Extra;

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        // Use a set to store unique elements
        Set<Integer> set = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {
            // If the set already contains the current element, it is a duplicate
            if (set.contains(num)) {
                return true;
            }

            // Otherwise, add the element to the set
            set.add(num);
        }

        // No duplicates found
        return false;
    }
}
