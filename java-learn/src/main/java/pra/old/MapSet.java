package src.main.java.pra.old;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapSet {
    public static void main(String[] args) {
        HashMap s = new HashMap();
        s.put(1,"a");
        s.put(2,"b");
        s.put(3,"c");
        Set se = s.keySet();
        for (Iterator iterator = se.iterator(); iterator.hasNext(); ) {
            Object key =  iterator.next();
            Object value = s.get(key);
            System.out.println(key + ":" + value);
        }
    }
}
