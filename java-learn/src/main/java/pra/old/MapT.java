package src.main.java.pra.old;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapT {
    public static void main(String[] args) {
        HashMap<String, String> a = new HashMap<>();
        a.put("a","aa");
        a.put("b","bb");
        a.put("c","cc");

        Set<String> s = a.keySet();
        for (String next : s) {
            System.out.println(next + ":" + a.get(next));
        }

        Set<Map.Entry<String,String>> s2 = a.entrySet();
        for (Map.Entry<String, String> next : s2) {
            System.out.println(next.getKey() + ":" + next.getValue());
        }
    }
}
