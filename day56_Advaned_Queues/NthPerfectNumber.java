package day56_Advaned_Queues;

import java.util.LinkedList;
import java.util.Queue;
//TC - O(N)
//SC - O(N)
public class NthPerfectNumber {
    public static int findNthPerfectNumber(int n) {
        // Using a queue to generate perfect numbers
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");

        //Delete an element and add next 2 elements in series into the queue, Repeat it till N-1 times
        for (int i = 1; i < n; i++) {
            String current = queue.poll();
            queue.offer(current + "1"); // Append 1 to the current perfect number
            queue.offer(current + "2"); // Append 2 to the current perfect number
        }

        // Convert the final perfect number from string to integer
        return Integer.parseInt(queue.peek());
    }

    public static void main(String[] args) {
        int n = 6; // Change n to find different perfect numbers
        int nthPerfectNumber = findNthPerfectNumber(n);
        System.out.println("The " + n + "th perfect number is: " + nthPerfectNumber);
    }
}
