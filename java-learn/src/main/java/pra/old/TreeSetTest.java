package src.main.java.pra.old;

import java.util.Iterator;

public class TreeSetTest {
    public static void main(String[] args) {
        java.util.TreeSet s = new java.util.TreeSet();
        s.add("a");
        s.add("b");
        s.add("c");
        System.out.println(s);
        for (Iterator iterator = s.iterator(); iterator.hasNext(); ) {
            String next = (String) iterator.next();
            System.out.println(next);
        }
    }
}
