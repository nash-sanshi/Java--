package src.main.java.day6;

public class Test1
{
	public static void main (String[] args)
	{
		MyClass myClass = new MyClass();
		myClass.output();
		myClass.output2();
		myClass.output3();
	}
}

interface MyInterface
{
	public void output();
}

interface MyInterface2
{
	public void output2();
}

interface MyInterface3
{
	int a = 1;
}

class MyParent
{
	public void output3()
	{
		System.out.println("output3");
	}
}

//һ����ʵ����ĳ���ӿڣ���ô�������Ҫʵ�ֽӿ������������з�����
//����÷����Ǹ������࣬��ô������Ҫʵ�ֽӿ��еķ���
//�ȿ��Լ̳и��࣬�ֿ���ʵ�ֶ���ӿڣ��ö��ŷָ�
class MyClass extends MyParent implements MyInterface,MyInterface2
{
	public void output()
	{
		System.out.println("output");
	}
	public void output2()
	{
		System.out.println("output2");
	}
}

