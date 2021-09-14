package src.main.java.pra.old;

import java.util.HashMap;
import java.util.Map;

public class ArgsFor {
    public static void main(String[] args) {
        Map<String, Integer> a = new HashMap<>();
        for (String arg : args) {
            //hashmap.merge(key, value, remappingFunction)
            //如果 key 对应的 value 不存在，则返回该 value 值，如果存在，则返回通过 remappingFunction 重新计算后的值。
            //a.merge(arg, 1, Integer::sum);
            a.put(arg,a.get(arg)==null? 1:a.get(arg)+1);
           /* if (a.get(arg) == null) {
                a.put(arg, 1);
            } else {
                a.put(arg, a.get(arg)+1);
            }*/
        }
        System.out.println(a);
        for (String s : a.keySet()) {
            System.out.println(s+":"+ a.get(s));
        }
    }
}
