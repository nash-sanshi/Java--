package src.main.java.day5;

public class Five4_StaticTest
{
	public static void main(String [] args)
	{
		//P p = new P();
		//P p2 = new P();
		new S();
		//new S();
	}
	
}

class P
{
	static//��̬�����
	{
		System.out.println("P static");
	}
	
	public P()//���췽����newһ��ִ��һ��
	{
		System.out.println("P constructor");
	}
}

class Q extends P
{
	static
	{
		System.out.println("Q static");
	}
	
	public Q()
	{
		System.out.println("Q constructor");
	}
}

class S extends Q
{
	static
	{
		System.out.println("S static");
	}
	
	public S()
	{
		System.out.println("S constructor");
	}
}