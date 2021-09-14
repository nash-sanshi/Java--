package src.main.java.pra;

import java.util.HashMap;
import java.util.Map;

public class Pra2_ArgsMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (String arg : args) {
            map.put(arg,(null == map.get(arg))? 1 : map.get(arg)+1);
        }
        System.out.println(map);
    }
}
