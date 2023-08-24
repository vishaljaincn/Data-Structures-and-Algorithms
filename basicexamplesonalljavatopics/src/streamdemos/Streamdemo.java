package streamdemos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Streamdemo 
{
	public static void main(String args[])
	{
		//Map method demo
		List<Integer> numberList=new ArrayList<>();
		numberList.add(10);
		numberList.add(20);
		numberList.add(30);
		numberList.add(40);
		System.out.println(numberList);
		
//		map method demo
		List<Integer> squareList=new ArrayList<>();
		for(int i:numberList)
		{
			squareList.add(i*i);
		}
		System.out.println(squareList);
		
		List<Integer>dsquarelist =numberList.stream().map(x->x*x).collect(Collectors.toList());
		System.out.println(dsquarelist);
		
		Set<Integer>squareSet=new HashSet<>();
		for(int i:numberList)
		{
			squareSet.add(i*i);
		}
		System.out.println(squareSet);
		
		Set<Integer> dsquareSet=numberList.stream().map(x->x*x).collect(Collectors.toSet());
		System.out.println(dsquareSet);
		
		//Filter method demo
		List<String> languages=new ArrayList<>();
		languages.add("scala");
		languages.add("python");
		languages.add("java");
		languages.add("pojo");
		languages.add("basic");
		System.out.println(languages);
		
		List<String> filterresult=new ArrayList<>();
		for(String s:languages)
		{
			if(s.startsWith("p"))
			{
				filterresult.add(s);
			}
		}
		System.out.println(filterresult);
		
		List<String> dfilteresult=languages.stream().filter(s->s.startsWith("p")).collect(Collectors.toList());
		System.out.println(dfilteresult);
		
		List<String> sortedList=languages.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		
		languages.stream().forEach(y->System.out.println("elemet is : "+y));
		
		languages.stream().forEach(y->{
			System.out.println("elemet is : "+y);
			System.out.println("hi");});
		
		int sum=numberList.stream().reduce(0,(ans,i)->(ans+i));
		System.out.println(sum);
	}
	
}
