package java8practicequestions;

import java.util.Arrays;
import java.util.List;

public class CountStringswhoselengthisgreaterthan3inList {

	public static void main(String[] args) {
		
		List<String>list=Arrays.asList("hi","hello","mofo","lol","vishal","jain");
		
//		To count the no of strings whose length is greater than 3 
		long count=list.stream().filter(str->str.length()>3).count();
		System.out.println("the count of strings whose length is greter than 3 is "+count);
		
//		To print the strings whose length is greater than 3
		list.stream().filter(str->str.length()>3).forEach(System.out::println);
	}

}
