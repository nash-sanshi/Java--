package src.main.java.pra;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Pra15_Invoke {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> classType = Pra15_Invoke.class;
        Object object = classType.newInstance();

        Method add = classType.getDeclaredMethod("add", int.class, int.class);
        System.out.println(add.invoke(object, 1, 2));
        Method print = classType.getDeclaredMethod("print", String.class);
        System.out.println(print.invoke(object,"ฤ๚บร"));
    }

    public int add(int a, int b) {
        return a+b;
    }

    public String print(String str) {
        return str;
    }
}