package src.main.java.day4;

public class Four10_SingletonTest
{
	public static void main(String [] args)
	{
		Singleton s = Singleton.get();
		Singleton s2 = Singleton.get();
		System.out.println(s == s2);
	}
}

class Singleton
{
	//private static Singleton s = new Singleton();
	//防止外面使用new生成对象
	private Singleton() { }

	//因为方法是静态，所以对象也是静态
	private static Singleton s;

	//加static原因是：静态方法，直接用类名就可以调用对象，不需要new
	public static Singleton get()
	{
		if (s == null)
		{
			s = new Singleton();
		}
		return s;
	}
}