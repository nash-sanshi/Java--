package src.main.java.day5;

public class Five6_FinalTest2
{
	public static void main(String [] args)
	{
		People p = new People();
		//p.age = 20;
		//p.adddress = new Address();
		//���final����һ����������ʱ����ʾ���������Ͳ�����ָ�����������ˣ�����������ָ��Ķ���������ǿ��Ա仯��
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