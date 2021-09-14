package src.main.java.day3;

public class Three8_Test2 {
	public static void main(String [] args) {
		Person1[] p = new Person1[3];
		System.out.println(p[0]);  //引用类型没有赋值，结果为null
		p[0] = new Person1(10);
		p[1] = new Person1(20);
		p[2] = new Person1(30);
		System.out.println(p[0]);  //赋值后，结果为哈希值
		for(int i = 0;i < p.length; i++) {
			System.out.println(p[i].age);
		}
	}
}

class Person1
{
	int age;
	public Person1(int age)
	{
		this.age = age;
	}

	//public Person1() {}
}