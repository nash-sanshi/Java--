package src.main.java.day19;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Nineteen8_Test1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Nineteen6_PrivateTest privateTest = new Nineteen6_PrivateTest();
        Class<?> classType = privateTest.getClass();
        Method method = classType.getDeclaredMethod("sayHello", String.class);
        //ȡ��java�ķ��ʿ��Ƽ�飬����private����
        method.setAccessible(true);
        System.out.println((String) method.invoke(privateTest,"zhangsan"));

        Nineteen7_privateTest2 privateTest2 = new Nineteen7_privateTest2();
        Class<?> classType2 = privateTest2.getClass();
        Field field2 = classType2.getDeclaredField("name");
        //ȡ��java�ķ��ʿ��Ƽ�飬����private����
        field2.setAccessible(true);
        field2.set(privateTest2,"lisi");
        System.out.println(privateTest2.getName());
    }
}
