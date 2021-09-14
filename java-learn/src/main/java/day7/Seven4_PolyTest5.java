package src.main.java.day7;

public class Seven4_PolyTest5
{
	public static void main(String[] args)
	{
		/*
		PolyTest5 test = new PolyTest5();
		BMW bmw = new BMW();
		test.run(bmw);
		QQ qq = new QQ();
		test.run(qq);
		*/
		Seven4_PolyTest5 test = new Seven4_PolyTest5();
		Car bmw = new BMW();
		test.run(bmw);
		QQ qq = new QQ();
		test.run(qq);
	}
	/*
	public void run(BMW bmw)
	{
		bmw.run();
	}
	public void run(QQ qq)
	{
		qq.run();
	}
	*/
	//多态：父类包含了子类
	public void run(Car car)
	{
		car.run();
	}
}

class Car 
{
	public void run()
	{
		System.out.println("car is runing");
	}
}

class BMW extends Car
{
	public void run()
	{
		System.out.println("bmw is runing");
	}
}

class QQ extends Car
{
	public void run()
	{
		System.out.println("qq is runing");
	}
}