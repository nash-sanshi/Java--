package src.main.java.day9.rtwo;

public class Nine8_StaticInnerClassTest {
	public static void main(String[] args) {
		StaticInner.Inner inner = new StaticInner.Inner();
		inner.test();

	}
}

class StaticInner
{
	private static final int a = 4;
	//��̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա�����뾲̬����
	public static class Inner
	{
		public void test()
		{
			System.out.println(a);
		}
	}
}