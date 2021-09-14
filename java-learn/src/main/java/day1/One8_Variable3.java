package src.main.java.day1;

public class One8_Variable3
{
	public static void main(String[] args)
	{
		int a = 3;
		int b = a++;//a赋值给b，再自增
		int c = ++a;//a先自增，再赋值给c
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		int d = a--;
		int e = --a;
		System.out.println(d);
		System.out.println(e);
		
		int x,y,z;
		x = y = z = 4;
		x += 100; //x = x + 100;
		System.out.println(x);

		short s = 3;
		//s = s + 2;     //这是错误的，因为右边是int类型
		s += 2;        //这是正确的，因为这种会给两边同时赋值，两边都是short类型
		System.out.println("s=" +s);
		
		System.out.println(4 == 3);
	}
}