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
		//�ֲ��ڲ��ࣺ�����ڷ������У�ֻ�ܷ�������������������final���ͱ���
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