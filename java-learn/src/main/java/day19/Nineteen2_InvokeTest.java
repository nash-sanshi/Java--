package src.main.java.day19;

import java.lang.reflect.Method;

public class Nineteen2_InvokeTest {
    public static void main(String[] args) throws Exception {
        Class<?> classType = Nineteen2_InvokeTest.class;
        Object object = classType.newInstance();

        Method addMethod = classType.getMethod("add", int.class,int.class);
        //invoke在具有指定参数的方法对象上调用此方法对象表示的基础方法。
        Object result = addMethod.invoke(object, 1, 2);
        System.out.println(result);

        Method echoMethod = classType.getMethod("echo", String.class);
        Object result2 = echoMethod.invoke(object, "world");
        System.out.println(result2);
    }

    public int add(int param1,int param2){
        return param1+param2;
    }

    public String echo(String message) {
        return "hello:" + message;
    }
}
