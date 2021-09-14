package src.main.java.day4;

public class Four1_PeopleTest
{
	
	public static void main(String [] args)
	{
		People p = new People(10);
		System.out.println(p.age);
	}
	
}

class People
{
	int age;
	public People(int i)
	{
	age = i;
	}
}