package src.main.java.day4;

public class Four3_ConstrutorOverload
{
	public static void main(String[] arga)
	{
		Four3_ConstrutorOverload col = new Four3_ConstrutorOverload();
	}
	
	/*
	在一个构造方法中调用另外一个构造方法，使用this，()中为目标构造方法的参数
	this()之前不能有任何可以执行的代码
	 */
	public Four3_ConstrutorOverload()
	{
		this(3);
		System.out.println("test");
	}
	
	public Four3_ConstrutorOverload(int i)
	{
		System.out.println(++i);//i+1之后打印
	}
}