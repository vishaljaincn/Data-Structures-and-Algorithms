package day14_Interview_Problems;

public class Boolean_Increasing_Triplets_O_N {
    public static boolean increasingTriplet(int[] nums) {
        // Check if the array has less than 3 elements, in which case it's not possible to find a triplet.
        if (nums.length < 3)
            return false;

        // Initialize the two minimum values to the maximum possible value.
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Traverse through the array to find the increasing triplet pattern.
        for (int i = 0; i < nums.length; i++) {
            // Update min1 if the current element is smaller.
            if (nums[i] < min1) {
                min1 = nums[i];
            }
            // Update min2 if the current element is between min1 and min2.
            else if (nums[i] < min2 && nums[i] > min1) {
                min2 = nums[i];
            }
            // If a number larger than both min1 and min2 is found, an increasing triplet is found.
            else if (nums[i] > min1 && nums[i] > min2) {
                return true;
            }
        }

        // No increasing triplet pattern found in the array.
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 3};
        boolean result = increasingTriplet(arr);
        System.out.println("Is there an increasing triplet: " + result);
    }
}
