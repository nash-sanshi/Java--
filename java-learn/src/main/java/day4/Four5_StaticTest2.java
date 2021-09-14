package src.main.java.day4;

public class Four5_StaticTest2
{
	public static void main(String [] args)
	{
		/*
		MyStatic2 a = new MyStatic2();
		a.output();
		*/
		//对于静态方法来说，可以使用类名.方法名的方式来访问
		MyStatic2.output();
	}
}

class MyStatic2
{
	public static void output()
	{
		System.out.println("output");
	}
}