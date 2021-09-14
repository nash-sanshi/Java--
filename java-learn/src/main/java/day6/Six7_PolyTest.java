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
//		//多态：子类就是父类因为多态的含义就是：父类型的引用可以指向子类型的对象
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