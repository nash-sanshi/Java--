package src.main.java.day9.rtwo;

public class Nine10_LocalInnerClassTest {
	public static void main(String[] args) {
		LocalInner b = new LocalInner();
		b.doSomething();
	}
}

class LocalInner
{
	void doSomething()
	{
		 final int a = 4;
		//局部内部类：定义在方法当中，只能访问声明方法中声明的final类型变量
		class Inner3
		{
			public void test()
			{
				System.out.println(a);
			}
		}
		new Inner3().test();
	}
}