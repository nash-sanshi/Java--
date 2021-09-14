package src.main.java.pra.old;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapArgs {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        for (String arg : args) {
            if (map.get(arg) == null) {
                map.put(arg, 1);
            } else {
                Integer in = (Integer) map.get(arg);
                in = in.intValue() + 1;
                map.put(arg, in);
            }
        }

        Set set = map.keySet();
            for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
                Object key =  iterator.next();
                Object value = map.get(key);
                System.out.println(key + ":" + value);
            }
    }
}
