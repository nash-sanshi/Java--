package src.main.java.pra.old;

import java.util.*;

public class For {
    public static void main(String[] args) {
        int i = 0;
        for (int a = 0; a <= 100; a++) {
            i = i + a;
        }
        System.out.println(i);
        System.out.println("ÎÒÊÇË­");

        int[] arr = {1, 2,3,4,5};
        for (int i1 : arr) {
            System.out.println(i1);
        }

        List<String> b = new ArrayList<>();
        b.add("aaa");
        b.add("bbb");
        b.add("ccc");
        for (String s : b) {
            System.out.println(s);
        }

        for(Iterator<String> iterator = b.iterator(); iterator.hasNext();){
            String next = iterator.next();
            System.out.println(next);
        }

        Map<String, String> c = new HashMap<>();
        c.put("a","aa");
        c.put("b","bb");
        c.put("c","cc");
        for (String s : c.keySet()) {
            System.out.println(s+":"+c.get(s));
        }

        for (Map.Entry<String, String> s2 : c.entrySet()) {
            System.out.println(s2.getKey()+":"+ s2.getValue());
        }
    }
}
