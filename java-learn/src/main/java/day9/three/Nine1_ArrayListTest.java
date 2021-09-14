package src.main.java.day9.three;

import java.util.ArrayList;

public class Nine1_ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("string");
		list.add(2);
		list.add(3);

//		Object str = (String)list.get(0);
//		Integer in = (Integer)list.get(1);
		System.out.println(list.get(0));
		System.out.println(list.get(1));

		System.out.println("--------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("--------------------------");
		list.clear();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.size());
		System.out.println(list);
	}
}
