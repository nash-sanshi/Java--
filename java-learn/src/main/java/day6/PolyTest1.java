package src.main.java.day6;

public class PolyTest1
{
	public static void main(String[] args)
	{
		
		Parent1 p = new Parent1();
		p.sing();
		System.out.println("---------------------");
		//û�д�ӡparent��Ϊʲô����Ϊsing����ͨ���������ǹ��췽��
		Child1 c =new Child1();
		c.sing();
		System.out.println("---------------------");
		//��̬��������Ǹ�����Ϊ��̬�ĺ�����ǣ������͵����ÿ���ָ�������͵Ķ���
		Parent1 g = new Child1();
		g.sing();
	}
}

class Parent1
{
	public  void sing() { System.out.println("parent is singing"); }
}

class Child1 extends Parent1
{
	public  void sing()
	{
	System.out.println("child is singing");
	}
}