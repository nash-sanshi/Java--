package src.main.java.day9.one;

import java.util.LinkedList;

public class Nine5_LinkedListTest1 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("F");
		list.add("B");
		list.add("D");
		list.add("E");
		list.add("C");
		list.addLast("Z");
		list.addFirst("A");
		list.add(1,"A2");
		System.out.println("最初的集合："+ list);
		list.remove("F");
		list.remove(2);
		System.out.println("变化后的集合："+ list);
		Object value = list.get(2);
		System.out.println(value);
		//强制类型转换，把object类型转换为string类型
		list.set(2, (String)value+ "changed");
		System.out.println("最后的集合："+ list);
	}
}
