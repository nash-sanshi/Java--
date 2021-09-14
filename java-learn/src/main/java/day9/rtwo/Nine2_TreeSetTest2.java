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
		//����Person�������С��������
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
Ϊ����Person�߱���Ȼ�����ܣ�������Խ��бȽ�
����Ҫ��person�߱��ȽϹ��ܣ��ù����Ѿ�������Comparable�ӿ�
ֻҪʵ��comparable�ӿڸ���compareTo����
*/
class Person implements Comparable
{
	private String name;
	private int age;
	//���ɹ��췽��
	public Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	//��дtosTring
	public String toString()
	{
		return "Person[name=" + name + ",age=" + age +"]";
	}

	@Override
	public int compareTo(Object o) {
		//ͨ��������бȽ�
		if(!(o instanceof Person))
		{
			throw new ClassCastException("���ʹ���");
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