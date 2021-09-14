package src.main.java.day19;

import java.lang.reflect.Array;

public class Nineteen4_ArrayTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classType = Class.forName("java.lang.String");
//        System.out.println(classType.getName());
//        System.out.println(classType.getClass());
//        System.out.println(classType.getTypeName());
        Object array = Array.newInstance(classType,10);
        Array.set(array, 5, "hello");
        String str = (String) Array.get(array, 5);
        System.out.println(str);
    }
}
