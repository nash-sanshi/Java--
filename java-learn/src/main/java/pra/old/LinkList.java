package src.main.java.pra.old;

import java.util.LinkedList;

public class LinkList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        list.add(2,"d");
        System.out.println(list);
        System.out.println(list.get(3));
        Object set = list.set(1, "ch");
        System.out.println(list);
    }
}
