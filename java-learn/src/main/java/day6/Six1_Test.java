package src.main.java.day6;

public class Six1_Test
{
	public static void main(String[] args)
	{
		//�������޷�ʵ������Ҳ����˵����new����һ��������Ķ���
		//AbstractTest at = new AbstractTest();
		//R r = new R();
	}
}

abstract class T
{
	public abstract void method();
	public void test()
	{
		System.out.println("test");
	}
}

// ������̳и��ࣨ�����Ǹ������ࣩ������£�
// ��ô���������Ҫʵ�ָ���������������г��󷽷���
// ���򣬸�������Ҫ������һ��abstract class
 class R extends T
{
	public void method()
	{
		System.out.println("method");
	}
}