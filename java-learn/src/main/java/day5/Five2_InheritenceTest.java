package src.main.java.day5;

public class Five2_InheritenceTest
{
	public static void main(String[] args)
	{
		Apple a = new Apple();
		System.out.println(a.name);
	}
}

class Fruit
{
	String name = "fruit";
}

class Apple extends Fruit
{
	String name = "apple";
}