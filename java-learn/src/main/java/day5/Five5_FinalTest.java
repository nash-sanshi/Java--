package src.main.java.day5;

public class Five5_FinalTest
{
	public static void main(String [] args)
	{
		F f = new F();
		f.output();//void普通方法，而不是构造方法，所以父类方法不会执行
	}
}
/*
//final类不能被继承
final class E
{
	
}
*/

class E
{
	//如果方法加上final关键字，就不能被重写
	public void output()
	{
		System.out.println("E");
	}
}

class F extends E
{
	public void output()
	{
		System.out.println("F");
	}
}