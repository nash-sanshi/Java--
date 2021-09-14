package src.main.java.day5;

public class Five3_InheritenceTest2
{
	public static void main(String[] args)
	{
		Dog dog = new Dog();
		dog.run();
	}
}

class Animal
{
	public void run()
	{
		System.out.println("animal is running");
	}
}

class Dog extends Animal
{
	public void run()
	{
		//在子类方法中通过super.run()形式调用父类的run方法
		super.run();
		System.out.println("dog is running");
		//其中super.run不必放在第一行语句，因为此时父类对象已经构造完毕，run为普通方法
		super.run();
	}
}