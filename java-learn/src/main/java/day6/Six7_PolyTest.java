package src.main.java.day6;

public class Six7_PolyTest
{
	public static void main(String[] args)
	{
		
//		Parent p = new Parent();
//		p.sing();
//		System.out.println("---------------------");
		Child c =new Child();
		new Child();
		System.out.println("---------------------");
//		//��̬��������Ǹ�����Ϊ��̬�ĺ�����ǣ������͵����ÿ���ָ�������͵Ķ���
//		Parent g = new Child();
//		g.sing();
	}
}

class Parent
{
	public  Parent() { System.out.println("parent is singing"); }
}

class Child extends Parent
{
	public  Child()
	{
	System.out.println("child is singing");
	}
}