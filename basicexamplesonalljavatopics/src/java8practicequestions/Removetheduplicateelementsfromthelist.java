package java8practicequestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Removetheduplicateelementsfromthelist {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,3,2,1);
		System.out.println(list);
		System.out.println("After removing duplicate elements : ");
		System.out.println(list.stream().collect(Collectors.toSet()));
		list.stream().collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println(list);

	}

}
