package src.main.java.day7;

public class PolyTest3
{
	public static void main(String[] args)
	{
		/*
		Fruit f = new Apple();
		f.run();
		Apple p = (Apple)f;
		p.run();
		
		Fruit g = new Apple();
		g.grow();
		*/
		//使用子类中特有的方法父没有的方法，必须强制转换，父类型转换成子类型，调用子类型中的方法
		Fruit f = new Apple();
		Apple p = (Apple)f;
		p.grow();
	}
}

class Fruit
{
	public void run()
	{
		System.out.println("fruit is runing");
		
	}
}

class Apple extends Fruit
{
	public void run()
	{
		System.out.println("apple is runing");
		
	}
	
	public void grow()
	{
		System.out.println("apple is growing");
		
	}
}
