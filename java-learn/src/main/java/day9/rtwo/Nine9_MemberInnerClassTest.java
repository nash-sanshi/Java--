package src.main.java.day9.rtwo;

public class Nine9_MemberInnerClassTest {
	public static void main(String[] args) {
		MemberInner.Inner2 inner = new MemberInner().new Inner2();
		inner.doSomething();
	}
}

class MemberInner
{
	private final int a = 4;

	//成员内部类：可以访问外部类的静态与非静态的方法与成员变量。
	public class Inner2
	{
		private final int a = 5;
		public void doSomething()
		{
			System.out.println(MemberInner.this.a);
		}
	}
}