package src.main.java.day4;

public class Four4_StaticTest
{
	public static void main(String [] args)
	{
		MyStatic myStatic = new MyStatic();
		MyStatic myStatic2 = new MyStatic();
		myStatic.a = 10;
		System.out.println(myStatic2.a);
		
		//如果一个成员变量是static的，那么我们可以通过类名.成员变量名的方式来使用它（推荐使用这种方式）
		MyStatic.a = 20;
		System.out.println(myStatic.a);
	}
}

class MyStatic
{
	/*无论一个类生成了多少个对象，所有这些对象共同使用唯一一份静态的成员变量，
	 一个对象对该静态成员变量进行了修改，其他对象的改静态成员变量的值也会随之发生变化*/
	static int a;
}