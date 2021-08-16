package src.main.java.day7;

public class PolyTest2
{
	public static void main(String[] args)
	{
		Animal a = new Dog();
		Dog dog = (Dog)a;
		dog.sing();
		
		Animal b = new Cat();
		Cat cat = (Cat)b;
		cat.sing();
		
		//这就是错误的，b已经是cat了，不能强制转换赋给dog
		//多态是允许时才判断出来的，编译可以通过
		Dog d = (Dog)b;
		d.sing();

		/*
		向下类型转换
		Animal animal = new Cat();
		Animal animal2 = new Animal();
		
		animal2 = animal;
		animal2.sing();
		
		animal = animal2;
		animal.sing();
		
		向上类型转换
		Cat cat = new Cat();
		Animal animal = cat;
		animal.sing();
		*/
		
	}
}

class Animal
{
	public void sing()
	{
		System.out.println("animal is singing");
	}
}

class Dog extends Animal
{
	public void sing()
	{
		System.out.println("dog is singing");
	}
}

class Cat extends Animal 
{
	public void sing()
	{
		System.out.println("cat is singing");
	}
}