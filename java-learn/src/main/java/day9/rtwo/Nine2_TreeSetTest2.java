package src.main.java.day9.rtwo;

import java.util.Iterator;
import java.util.TreeSet;

public class Nine2_TreeSetTest2 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		Person p1 = new Person("zhangsan",50);
		Person p2 = new Person("lisi",20);
		Person p3 = new Person("wangwu",40);
		Person p4 = new Person("zhaoliu",30);
		//按照Person的年龄从小到大排序
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
			Person next = (Person) iterator.next();
			System.out.println(next);
		}
	}
}

/*
为了让Person具备自然排序功能，必须可以进行比较
就需要让person具备比较功能，该功能已经定义在Comparable接口
只要实现comparable接口覆盖compareTo方法
*/
class Person implements Comparable
{
	private String name;
	private int age;
	//生成构造方法
	public Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	//重写tosTring
	public String toString()
	{
		return "Person[name=" + name + ",age=" + age +"]";
	}

	@Override
	public int compareTo(Object o) {
		//通过年龄进行比较
		if(!(o instanceof Person))
		{
			throw new ClassCastException("类型错误");
		}
		Person p = (Person)o;
/*		if(this.age > p.age)
		{
			return 1;
		}else if (this.age < p.age)
		{
			return -1;
		}else
		return 0;*/
		return this.age - p.age;
	}
}