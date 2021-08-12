package src.main.java.day1;

public class Variable2
{
	public static void main(String[] args)
	{
		int a = 1;
		int b = 2;
		int c = a + b;
		int d = a - b;
		int e = a * b;
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);

		//a/b是int类型，需要转换成double类型
		double f = (double)a / b;
		System.out.println(f);

		int g = 5;
		int h = 3;
		int i = g % h; //取模
		System.out.println(i);
		System.out.println("您好");
	}
}