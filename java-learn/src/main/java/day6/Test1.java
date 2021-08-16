package src.main.java.day6;

public class Test1
{
	public static void main (String[] args)
	{
		MyClass myClass = new MyClass();
		myClass.output();
		myClass.output2();
		myClass.output3();
	}
}

interface MyInterface
{
	public void output();
}

interface MyInterface2
{
	public void output2();
}

interface MyInterface3
{
	int a = 1;
}

class MyParent
{
	public void output3()
	{
		System.out.println("output3");
	}
}

//一个类实现了某个接口，那么该类必须要实现接口中声明的所有方法，
//如果该方法是个抽象类，那么就无需要实现接口中的方法
//既可以继承父类，又可以实现多个接口，用逗号分隔
class MyClass extends MyParent implements MyInterface,MyInterface2
{
	public void output()
	{
		System.out.println("output");
	}
	public void output2()
	{
		System.out.println("output2");
	}
}

