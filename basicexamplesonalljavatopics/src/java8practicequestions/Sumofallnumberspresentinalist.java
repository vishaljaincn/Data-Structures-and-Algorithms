package java8practicequestions;

import java.util.Arrays;
import java.util.List;

public class Sumofallnumberspresentinalist {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(4,5,6,7,1,2,3);
		int sum=list.stream().reduce(0,(ans,i)->(ans+i));
		System.out.println(sum);
	}

}
