package src.main.java.day9.one;

import java.util.HashSet;

public class SetTest1 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("d");
		System.out.println(set);
	}
}
