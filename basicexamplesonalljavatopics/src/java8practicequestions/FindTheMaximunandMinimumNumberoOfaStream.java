package java8practicequestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class FindTheMaximunandMinimumNumberoOfaStream {

	public static void main(String[] args) {
		
		List<Integer>list1=Arrays.asList(5,4,2,10,3,8,6);
		System.out.println(list1);
		int minInteger1=list1.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Min Integer is : "+minInteger1);
		int maxInteger1=list1.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Max Integer is : "+maxInteger1);

		List<Integer>list2=new ArrayList<>();
		list2.add(4);
		list2.add(3);
		list2.add(9);
		list2.add(5);
		list2.add(6);
		list2.add(1);
		list2.add(2);
		System.out.println(list2);
		int minInteger2=list2.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(minInteger2);
		int maxInteger2=list2.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(maxInteger2);
			
		int minInteger3=Stream.of(3,5,11,4,8,6,7).min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(minInteger3);
		
		int maxInteger3=Stream.of(2,3,5,12,4,1,6,7).max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(maxInteger3);


	}

}
