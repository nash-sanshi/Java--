package src.main.java.day9.one;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add("C");
		set.add("A");
		set.add("B");
		set.add("E");
		set.add("D");
		
		/*for(Iterator it = set.iterator();it.hasNext();)
		{
			System.out.println(it.next());
		}*/
		for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
			//String next = (String) iterator.next();
			System.out.println(iterator.next());
		}
		for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
			//String next = (String) iterator.next();
			System.out.println(iterator.next());
		}
	}

}
