package src.main.java.day9.three;

import java.util.ArrayList;
import java.util.List;

public class Nine2_ArrayListTest1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("--------------------");
		//µü´úÆ÷
		for (String value : list) {
			System.out.println(value);
		}
		System.out.println("--------------------");
		for (String next : list) {
			System.out.println(next);
		}
	}
}
