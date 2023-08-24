package java8practicequestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Multiply3toallelementsinthelistandprintthelist {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,4,5,6);
		System.out.println(list);
		System.out.println(list.stream().map(x->x*3).collect(Collectors.toList()));
		System.out.println(list);
		list.stream().map(x->x*3).forEach(System.out::println);
	}

}
