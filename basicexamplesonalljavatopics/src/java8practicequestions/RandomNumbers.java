package java8practicequestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class RandomNumbers {

	public static void main(String[] args) {
		Random random=new Random();
//		ints() method Returns unlimited stream of random int values
		random.ints().limit(10).forEach(System.out::println);
		random.ints().limit(10).forEach(x->System.out.println(x));
		
		
		List<Integer> list=Arrays.asList(1,3,9,5,7);
		Integer aInteger=list.stream().filter(x->x%2==0).map(x->x*5).findAny().orElse(333);
		System.out.println(aInteger);
		
		
		
		
		List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
		List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");

		Optional<String> findFirst = lst1.stream().filter(s -> s.startsWith("D")).findFirst();
		Optional<String> fidnAny = lst2.parallelStream().filter(s -> s.startsWith("J")).findAny();

		System.out.println(findFirst.get()); //Always print David
		System.out.println(fidnAny.get()); //Print Jack/Jill/Julia :behavior of this operation is explicitly nondeterministic
	}

}
