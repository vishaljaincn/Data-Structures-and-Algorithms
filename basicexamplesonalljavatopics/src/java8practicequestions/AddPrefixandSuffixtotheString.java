package java8practicequestions;

import java.util.StringJoiner;

public class AddPrefixandSuffixtotheString {
	public static void main(String[] args) {
//		when you want to create an object of StringJoiner class, you should pass 3 parameters
//		1)delimiter to separate sequence of characters
//		2)Supplied Prefix
//		3)Supplied suffix
	        StringJoiner stringJoiner = new StringJoiner(",", "#", "#");
	        stringJoiner.add("Interview");
	        stringJoiner.add("Questions");
	        stringJoiner.add("Answers");
	        System.out.println("String after adding # in suffix and prefix :");
	        System.out.println(stringJoiner);

	}
}
