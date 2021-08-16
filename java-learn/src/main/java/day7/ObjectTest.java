package src.main.java.day7;

public class ObjectTest
{
	public static void main(String[] args)
	{
		Object o = new Object();
		System.out.println(o);
		System.out.println(o.toString());
		
		String str = "aaa";
		System.out.println(str);
		System.out.println(str.toString());
		
		Student s = new Student();
		System.out.println(s);
		System.out.println(s.toString());
	}
}

class Student
{
	public String toString()
	{
		return "Hello World";
	}
}