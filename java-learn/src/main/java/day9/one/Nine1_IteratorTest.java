package src.main.java.day9.one;

import java.util.HashSet;
import java.util.Iterator;

public class Nine1_IteratorTest {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");
		System.out.println(set);
/*		Iterator iter = set.iterator();
		while(iter.hasNext())
		{
			String value = (String) iter.next();
			System.out.println(value);
		}*/

		//��ݼ�itco
		for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
			String next = (String) iterator.next();
			System.out.println(next);
		}
	}
}
