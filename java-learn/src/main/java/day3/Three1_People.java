package src.main.java.day3;

public class Three1_People {
	int age = 20;
	public void change(Three1_People c) {
		//c = new People();     //新生成一个对象，下一步c赋值30
		c.age = 30;
	}
	
	public static void main(String[] args) {
		Three1_People p = new Three1_People();
		int age = p.age;
		System.out.println(age);
		
		p.change(p);
		int age2 = p.age;
		System.out.println(age2);
	}
}