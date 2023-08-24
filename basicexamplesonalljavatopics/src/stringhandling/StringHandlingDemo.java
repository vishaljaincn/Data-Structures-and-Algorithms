package stringhandling;

import java.util.Arrays;
import java.util.Scanner;

public class StringHandlingDemo
{

	public static void main(String[] args)
	{
		String str1= "John is Studying";
		String str2= " In college";
		String str3= "John is Studying";
//		You can concat more then 2 strings
		System.out.println(str1.concat(str2).concat(str3).concat(str3).concat(str1));
		System.out.println(str1.concat(" hi"));
		System.out.println(str1);
		char[]b= {'c','b','a'};
		System.out.println(b);
		Arrays.sort(b);
		System.out.println(b);
		
		 
		System.out.println(str1.length());
		
		String resultString =str1.concat(str2);
		System.out.println(resultString);
		
		String formatString = String.format("student name is %s and the age is %d", "john",21);
		System.out.println(formatString);
		
		System.out.println(String.format("student name is %s and the age is %d", "john",21));
		
		System.out.println(str1.charAt(5));
		
		//It returns the index of first appearance of char 'i' and returns -1 if char 'i' is not present in the string.
		System.out.println(str1.indexOf("i"));
		
		if(str1.equals(str3))
		{
			System.out.println("Both strings are equal");
		}
		else
		{
			System.out.println("Both Strings are different");
		}
		if(str1.equalsIgnoreCase(str3))
		{
			System.out.println("Both strings are equal");
		}
		else
		{
			System.out.println("Both Strings are different");
		}
		
		
		//Replaces the char 'i' with char 'x' in all the places where  char 'i' is present in the string
		System.out.println(str1.replace('i', 'x'));
		String replaceString=str1.replace('i', 'x');
		System.out.println(replaceString);
		System.out.println(str1);
		
		//split the string based on regex (" " -> space here)
		String arr[]=str1.split(" ");
		for(String string : arr)
		{
			System.out.println(string);
		}
		
		//   OR
		
		Arrays.asList(arr).stream().forEach(x->System.out.println(x));
		System.out.println(arr.length);
		
		//while using substring method, the beginning index is printed and end index is not printed
		String subString=str1.substring(1, 5);
		System.out.println(subString);
		
//		If only beginning index is given, it will print from beginning index to end of the string
		System.out.println(str1.substring(5));
		
//		returns positive integer if string1 > string2, negative no if string1<string2, 0 if string1 is equal to string2
		int i=str1.compareTo(str2);
		System.out.println(i);
		int d=str2.compareTo(str1);
		System.out.println(d);
		int j=str1.compareTo(str3);
		System.out.println(j);
		
		System.out.println(str1.endsWith("g"));
		
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
		
		//trim() will remove the spaces in the front and in the end and not in the middle
		String str4="   Hello World    ";
		String trimString= str4.trim();
		System.out.println(str4);
		System.out.println(trimString);
		
		System.out.println(str1.contains("J"));
		
		char [] cArray=str1.toCharArray();
		for(char c:cArray)
		{
			System.out.println(c);
		}
		System.out.println(str1.isEmpty());
		
		str1.concat("Hello");
		System.out.println(str1);// Strings are immutable so "world" is not added to the original string
		
		//concat is for strings and append is for StringBuffer and StringBuilder
		StringBuffer stringBuffer=new StringBuffer("Hello ");//thread safe
		stringBuffer.append("World");
		System.out.println(stringBuffer);
		
		StringBuilder stringBuilder=new StringBuilder("Hello ");//not thread safe
		stringBuilder.append("World!!!!");
		System.out.println(stringBuilder);
		
//		To reverse a string
		String toreverseString="Hi vishal jain 123";
		System.out.println(toreverseString);
		for(int y=toreverseString.length()-1;y>=0;y--)
		{
			System.out.print(toreverseString.charAt(y));
		}
		System.out.println();
		System.out.println(toreverseString+Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		
//		To reverse a user input string 
		Scanner scanner=new Scanner(System.in);
		String torevString=scanner.nextLine();
		for(int j1=torevString.length()-1;j1>=0;j1--)
		{
			System.out.print(torevString.charAt(j1));
		}
		System.out.println();
		System.out.println(torevString);
		scanner.close();
		
		
	}

}
