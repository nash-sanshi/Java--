package src.main.java.pra.old;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListT {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        System.out.println(a);
        for (Iterator<String> iterator = a.iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            System.out.println(next);
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }

}
