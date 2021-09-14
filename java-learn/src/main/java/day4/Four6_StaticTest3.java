package src.main.java.day4;

public class Four6_StaticTest3
{
	public static void main(String [] args)
	{
		MyStatic3.change();
	}
}

class MyStatic3
{
	static int a = 10;
	public static void change()
	{
		a++;
		System.out.println(a);
	}
}