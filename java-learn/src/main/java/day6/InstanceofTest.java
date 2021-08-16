package src.main.java.day6;

public class InstanceofTest
{
	public static void main(String[] main)
	{
		People p = new People();
		//instanceof：判断某个对象是否是某个类的实例
		//语法形式：引用名instanceof类名（接口名），返回一个boolean值
		System.out.println(p instanceof People);
		System.out.println(p instanceof Man);
	}
}

class People
{
	
}

class Man extends People 
{
	
}