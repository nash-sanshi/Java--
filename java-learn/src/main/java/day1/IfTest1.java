package src.main.java.day1;

public class IfTest1
{
	/**
	需求：对用户的输入的数字给出对应的星期
	思路：
	1.怎么获取用的数据
	2.要对数据进行判断，给出对应的星期
	步骤：
	1.定义一个变量，用于记录不确定的数据
	2.使用判断结构的语句对该数据进行操作
	3.在每一个判断项中定义具体的对应日期
	4.通过输出语句将其显示在控制台上
	*/
	public static void main(String [] args)
	{
		int week = 7;
		if (week ==1)
		{
			System.out.println(week + "是星期一");
		} 
		else if (week == 2)
		{
			System.out.println(week + "是星期二");
		}
		else if (week == 3)
		{
			System.out.println(week + "是星期三");
		}
		else if (week == 4)
		{
			System.out.println(week + "是星期四");
		}
		else if (week == 5)
		{
			System.out.println(week + "是星期五");
		}
		else if (week == 6)
		{
			System.out.println(week + "是星期六");
		}
		else if (week == 7)
		{
			System.out.println(week + "是星期日");
		}
		else
		System.out.println(week + "的星期不存在");
	}
}