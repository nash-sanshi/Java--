package src.main.java.day1;

public class SwitchTest
{
	public static void main(String[] args)
	{
		int a = 3;
		switch(a)
		{
			case 1:
			System.out.println("a == 1");
			break;
			case 2:
			System.out.println("a == 2");
			break;
			case 3:
			System.out.println("a == 3");
			break;
			default:
			System.out.println("default");
		}
		//if语句
		if (a == 1)
		{
			System.out.println("a == 1");
		}
		else if (a == 2)
		{
			System.out.println("a == 2");
		}
		else if (a == 3)
		{
			System.out.println("a == 3");
		}
		else
		{
			System.out.println("default");
		}
	}
}