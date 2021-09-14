package src.main.java.day4;

public class Four10_SingletonTest
{
	public static void main(String [] args)
	{
		Singleton s = Singleton.get();
		Singleton s2 = Singleton.get();
		System.out.println(s == s2);
	}
}

class Singleton
{
	//private static Singleton s = new Singleton();
	//��ֹ����ʹ��new���ɶ���
	private Singleton() { }

	//��Ϊ�����Ǿ�̬�����Զ���Ҳ�Ǿ�̬
	private static Singleton s;

	//��staticԭ���ǣ���̬������ֱ���������Ϳ��Ե��ö��󣬲���Ҫnew
	public static Singleton get()
	{
		if (s == null)
		{
			s = new Singleton();
		}
		return s;
	}
}