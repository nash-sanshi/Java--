package src.main.java.day3;

public class Three4_ArrayTest
{
	public static void main(String [] args)
	{
		Student[] s = new Student[5];
		for (int i = 0; i < s.length; i ++)
		{
			s[i] = new Student();
			s[i].name = (i % 2 == 0 ? "zhangsan" : "lisi");
		}
		System.out.println(s.length);
		for (int i = 0; i < s.length; i ++)
		{
			System.out.println(s[i].name);
		}
	}
}

class Student
{
	String name;
}