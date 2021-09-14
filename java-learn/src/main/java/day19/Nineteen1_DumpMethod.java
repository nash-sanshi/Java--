package src.main.java.day19;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Nineteen1_DumpMethod {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classType = Class.forName("javax.print.attribute.standard.Media");
        Method[] methods = classType.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println(Arrays.toString(methods));
    }
}
