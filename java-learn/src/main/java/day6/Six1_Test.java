package src.main.java.day6;

public class Six1_Test
{
	public static void main(String[] args)
	{
		//抽象类无法实例化，也就是说不能new出来一个抽象类的对象
		//AbstractTest at = new AbstractTest();
		//R r = new R();
	}
}

abstract class T
{
	public abstract void method();
	public void test()
	{
		System.out.println("test");
	}
}

// 在子类继承父类（父类是个抽象类）的情况下，
// 那么该子类必须要实现父类中所定义的所有抽象方法；
// 否则，该子类需要声明成一个abstract class
 class R extends T
{
	public void method()
	{
		System.out.println("method");
	}
}