package src.main.java.day5;

public class Five6_FinalTest2
{
	public static void main(String [] args)
	{
		People p = new People();
		//p.age = 20;
		//p.adddress = new Address();
		//如果final修饰一个引用类型时，表示该引用类型不能再指向其他对象了，但该引用所指向的对象的内容是可以变化的
		p.address.name = "shanghai";
		System.out.println(p.address.name);
	}
	
}

class People
{
	//final int age = 10;
	final Address address = new Address();
}

class Address
{
	String name = "nantong";
}