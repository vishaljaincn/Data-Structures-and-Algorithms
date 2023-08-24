package com.java8defaultandstatic;

class TestClass implements TestInterface
{
    // Implementation of square abstract method
    public void square (int a)
    {
        System.out.println(a*a);
    }
    public void show()
    {
        System.out.println("hi bitch");
    }
    public void seek()
    {
    	System.out.println("hi mofo");
    }
    
    public static void main(String args[])
    {
        TestClass d = new TestClass();
        d.square(4);
        d.show();
        d.seek();
    }
}
