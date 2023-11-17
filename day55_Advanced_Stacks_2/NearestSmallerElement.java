package day55_Advanced_Stacks_2;
/*
The time complexity of the prevSmaller function is O(n), where n is the length of the input array A.
This is because each element is pushed onto the stack and popped off the stack at most once.

The space complexity is also O(n), as the stack can have at most n elements in it, and the additional space used
for the ans array is also proportional to the size of the input array.
 */
import java.util.Stack;

public class NearestSmallerElement {
    // Function to find the nearest smaller element for each element in the array
    public int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack until a smaller element is found or the stack is empty
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }

            // If the stack is empty, there is no smaller element to the left
            // Otherwise, the top element of the stack is the nearest smaller element
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            // Push the current element onto the stack
            stack.push(A[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        NearestSmallerElement solution = new NearestSmallerElement();

        // Example 1
        int[] A1 = {4, 5, 2, 10, 8};
        int[] result1 = solution.prevSmaller(A1);
        System.out.print("Output 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        // Output: -1 4 -1 2 2

        System.out.println(); // Add a newline for better readability

        // Example 2
        int[] A2 = {3, 2, 1};
        int[] result2 = solution.prevSmaller(A2);
        System.out.print("Output 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        // Output: -1 -1 -1
    }
}
