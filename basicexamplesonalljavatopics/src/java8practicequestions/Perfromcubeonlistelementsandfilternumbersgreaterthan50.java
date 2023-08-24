package java8practicequestions;

import java.util.Arrays;
import java.util.List;

public class Perfromcubeonlistelementsandfilternumbersgreaterthan50 {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(4,5,6,7,1,2,3);
		list.stream().map(x->x*x*x).filter(x->x>50).forEach(System.out::println);

	}

}
