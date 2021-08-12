package src.main.java.day2;

public class Lianxi
{
	/*
	练习1：判断两个整数是否相等
	练习2：打印乘法表
	练习3：打印给定的字符串信息
	练习4：定义功能获取两个整数中交大的整数
	*/
	
	
	/*
	练习1：判断两个整数是否相等
		1.返回类型boolean
		2.2个参数，int类型
	*/
	public static boolean compare(int a,int b)
	{
		if(a == b)
			return true;
		else
			return false;
		//return (a == b) ? true : false;
		//return a == b;
	}
	
	/*
	练习2：打印乘法表
		1.没有结果coid
		2.没有参数
	*/
	public static void printmult()
	{
		for(int x = 1;x <= 9;x++)
		{
			for(int y = 1;y <= x;y++)
			{
				System.out.print(y + "*" + x + "=" + y*x + "\t");
			}
			System.out.println();
		}
	}
	
	/*
	练习3：打印给定的字符串信息
	*/
	public static void printString(String str)
	{
		System.out.println(str);
	}
	
	/*
	练习4：定义功能获取两个整数中较大的整数
	*/
	public static int max(int a, int b)
	{
		if (a>b)
			return a;
		else
			return b;

		//retun (a > b)? a :b ;
	}
	
	public static void main(String[] args)
	{
		boolean c = compare(1, 2);
		printString("c=" +  c);
		printString("-------------");
		printmult();
		printString("-------------");
		int max = max(4,8);
		printString("max=" + max);
	}
}