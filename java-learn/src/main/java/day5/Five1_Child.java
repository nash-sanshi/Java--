package src.main.java.day5;

class Child1 extends Parent
{
	public Child1()
	{
		//������û�в��������Ĺ��췽��ʱ��������Ҫʹ��super����ʽ���ø���Ĺ��췽��
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
	//������˱���i������������Ҫ��i��ֵ
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

