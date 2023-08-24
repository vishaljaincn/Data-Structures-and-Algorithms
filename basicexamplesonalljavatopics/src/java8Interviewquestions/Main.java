package java8Interviewquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Employee employee1 = new Employee(1, "vishal", "HR", 24);
		Employee employee2 = new Employee(2, "rahul", "dev", 24);
		Employee employee3 = new Employee(3, "sreya", "prod", 24);
		Employee employee4 = new Employee(4, "swetha", "support", 24);
		Employee employee5 = new Employee(5, "rahul", "testing", 24);
		Employee employee6 = new Employee(6, "vishal", "sme", 24);
		Employee employee7 = new Employee(1, "rahul", "lead", 24);
		String string="Hi";
		String string2="hello";
		System.out.println(string.compareTo(string2));
		List<Employee> list = new ArrayList<Employee>();
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		list.add(employee4);
		list.add(employee5);
		list.add(employee6);
		list.add(employee7);
		Map<String, Long> countMap = list.stream()
				.collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
		System.out.println(countMap);

		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3, 2);
		Map<Integer, Long> numcountMap = list2.stream()
				.collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting()));
		System.out.println(numcountMap);

		List<Integer> list3 = new ArrayList<>();
		list3.add(1);
		list3.add(2);
		list3.add(1);
		list3.add(3);
		list3.add(2);
		list3.add(3);
		list3.add(4);

		System.out.println(list3);
//		easy way to convert a Arraylist to a Hashset
		Set<Integer> uniqueSet = new HashSet<Integer>(list3);
		System.out.println(uniqueSet);

		System.out.println(list3);
//		converting arraylist to hashset
		Set<Integer> uniqueSet2 = list3.stream().collect(Collectors.toSet());
		System.out.println(uniqueSet2);

// 		Let us create a list of strings
		List<String> mylist = new ArrayList<String>();
		mylist.add("practice");
		mylist.add("code");
		mylist.add("code");
		mylist.add("quiz");
		mylist.add("geeksforgeeks");
		
//		Here we are using frequency() method
//		to get frequency of element "code"
		int count=Collections.frequency(mylist, "code");
		System.out.println(count);
	
//		public static int frequency(Collection<?> c, Object o)
//		Parameters : 
//		c - the collection name in which to determine the frequency of o
//		o - the object whose frequency is to be determined
	}
}
