package linkedlistdemo;

import java.util.LinkedList;

public class Linkedlistdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> linkedList=new LinkedList<>();
		linkedList.add("A");
		linkedList.add("B");
		linkedList.addLast("C");
		linkedList.addFirst("D");
		linkedList.add(2,"E");
		System.out.println(linkedList);
		for(String string:linkedList)
		{
			System.out.println(string);
		}
		linkedList.remove("B");
		linkedList.remove(3);
		linkedList.removeFirst();
		linkedList.removeLast();
		System.out.println(linkedList);
		System.out.println(linkedList.get(0));

	}

}
