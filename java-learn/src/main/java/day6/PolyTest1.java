package src.main.java.day6;

public class PolyTest1
{
	public static void main(String[] args)
	{
		
		Parent1 p = new Parent1();
		p.sing();
		System.out.println("---------------------");
		//没有打印parent是为什么：因为sing是普通方法而不是构造方法
		Child1 c =new Child1();
		c.sing();
		System.out.println("---------------------");
		//多态：子类就是父类因为多态的含义就是：父类型的引用可以指向子类型的对象
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