package src.main.java.pra.old;

import java.util.HashMap;
import java.util.Map;

public class ArgsFor {
    public static void main(String[] args) {
        Map<String, Integer> a = new HashMap<>();
        for (String arg : args) {
            //hashmap.merge(key, value, remappingFunction)
            //��� key ��Ӧ�� value �����ڣ��򷵻ظ� value ֵ��������ڣ��򷵻�ͨ�� remappingFunction ���¼�����ֵ��
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
