package com.java8defaultandstatic;

public interface TestInterface {
	 // abstract method
  
    default void show()
    {
        System.out.println("Default Method Executed");
    }
    
    static void seek() {
	}
   
}
