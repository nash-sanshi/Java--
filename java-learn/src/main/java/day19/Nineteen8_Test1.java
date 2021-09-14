package src.main.java.day19;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Nineteen8_Test1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Nineteen6_PrivateTest privateTest = new Nineteen6_PrivateTest();
        Class<?> classType = privateTest.getClass();
        Method method = classType.getDeclaredMethod("sayHello", String.class);
        //取消java的访问控制检查，调用private方法
        method.setAccessible(true);
        System.out.println((String) method.invoke(privateTest,"zhangsan"));

        Nineteen7_privateTest2 privateTest2 = new Nineteen7_privateTest2();
        Class<?> classType2 = privateTest2.getClass();
        Field field2 = classType2.getDeclaredField("name");
        //取消java的访问控制检查，调用private方法
        field2.setAccessible(true);
        field2.set(privateTest2,"lisi");
        System.out.println(privateTest2.getName());
    }
}
