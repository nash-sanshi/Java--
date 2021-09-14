package src.main.java.day4;

public class Four2_PersonTest1
{
	public static void main(String [] args)
	{
		Person p = new Person();
		//p.age = 20;	//Person类中age进行了private私有化，没有权限赋值
		p.speak();
		p.method(-20);
		p.show();
		p.setAge(10);
		System.out.println(p.getAge());
	}
	
}

/*
通常将类中的成员变量进行私有化，对外提供方法对其进行访问
目的是对成员变量数据进行控制，让其具备可控性
定义set，get方法对成员变量进行访问
注意：私有化仅仅是封装的表现形式之一
私有化只能修饰成员变量
*/

class Person
{
	//使age私有化，访问权限最低
	private int age;
	
	public void speak()
	{
		System.out.println("age=" + age);
	}
	
	public void method(int a)
	{
		//加入数据校验判断
		if(a <= 0)
		{
			System.out.println("error");
		}else
		//将局部变量age赋值
		age = a;
	}
	
	public void show()
	{
		System.out.println("show age=" + age);
	}
	
	//set方法
	public void setAge(int a)
	{
		age = a;
	}
	//get方法
	public int getAge()
	{
		return age;
	}
}