package src.main.java.day2;

public class Hanshu
{
	/*
	返回值类型abc（参数类型 形式参数1，参数类型 形式参数2，......）
	{
	//执行语句
	return 返回值
	}

	需求：定义一个加法运算的功能
	思路：
		功能是java中的体现就是一个函数
		1.返回值类型是两个整数的和，int类型
		2.有参数参与运算，具体在使用该功能的时候才能明确有几个参数，int类型
		
	函数的好处：
		1.对细节进行封装
		2.提高了代码的复用性
	*/
	

	/*
	函数的特殊情况：
	当一个功能没有具体结果返回时，用关键字void来表示返回值类型
	void代表着没有具体返回值的情况
	当void类型的函数定义时，函数中的return后面直接分号结束
	同时，该return语句可以省略不写。但是编译器会帮你加上
	需求：
		将2个整数的和，打印到控制台
	思路：
		1.没有返回值，只能用void表示返回值类型
		2.有2个整数
		
	Return的作用：
		1.将具体的功能结果返回给调用者
		2.将函数结束，是一个结束标记
	*/
	public static int add (int x, int y)
	{
		return x + y;
	}
	
	public static void printsum(int a,int b)
	{
		System.out.println(a + b);
	}
	
	public static void main(String[] args)
	{
		//调用函数.1,2称为书籍参数
		int sum = add(1,2);
		int sum2 = add(2,3);
		System.out.println("sum=" + sum);
		System.out.println("sum2=" + sum2);
		printsum(1,2);
	}
}