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

	//��Ա�ڲ��ࣺ���Է����ⲿ��ľ�̬��Ǿ�̬�ķ������Ա������
	public class Inner2
	{
		private final int a = 5;
		public void doSomething()
		{
			System.out.println(MemberInner.this.a);
		}
	}
}