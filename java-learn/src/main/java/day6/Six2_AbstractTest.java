package src.main.java.day6;

//如果一个类中包含了抽象方法，那么这个类一定要声明成abstract class，
// 也就是说该类一定是抽象类，反之如果某个类是抽象类，
// 那么该类既可以包含抽象方法，也可以包含具体方法
public abstract class Six2_AbstractTest
{
	//abstract修饰的方法，叫做抽象方法
	public abstract void method() ;

	//具体方法，有声明，有实现
	public void test(){System.out.println("test");}

}