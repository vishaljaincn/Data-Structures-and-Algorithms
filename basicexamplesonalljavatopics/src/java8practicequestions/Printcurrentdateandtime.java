package java8practicequestions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Printcurrentdateandtime {

	public static void main(String[] args) {
		System.out.println("Current Date is "+LocalDate.now());
		System.out.println("Current Time is "+LocalTime.now());
		System.out.println(("Current Date and Time is "+LocalDateTime.now()));
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
	}

}
