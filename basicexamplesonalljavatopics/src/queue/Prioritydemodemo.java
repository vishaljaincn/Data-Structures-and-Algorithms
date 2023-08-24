package queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Prioritydemodemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> pQueue=new PriorityQueue<>();
		pQueue.add("India");
		pQueue.add("Germany");
		pQueue.add("America");
		System.out.println(pQueue);
		String removeString=pQueue.remove();
		System.out.println(removeString);
		System.out.println(pQueue);
		System.out.println(pQueue.peek());
		pQueue.poll();
		System.out.println(pQueue);
	}

}
