package src.main.java.day5;

class Child1 extends Parent
{
	public Child1()
	{
		//当父类没有不带参数的构造方法时，子类需要使用super来显式调用父类的构造方法
		super(1);
		System.out.println("Child");
	}
}

class Parent
{
	/*
	public Parent()
	{
		System.out.println("no args parent");
	}
	*/
	//父类带了变量i，所以子类需要给i赋值
	public Parent(int i)
	{
		System.out.println("parent");
	}
}

public class Five1_Child {
	public static void main(String [] args)
	{
		Child1 c = new Child1();
	}
}

