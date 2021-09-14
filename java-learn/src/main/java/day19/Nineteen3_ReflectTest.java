package src.main.java.day19;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Nineteen3_ReflectTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Nineteen3_ReflectTest test = new Nineteen3_ReflectTest();
        Customer c = new Customer("tom",20);
        c.setId(1L);
        Customer c2 = (Customer) test.copy(c);
        System.out.println(c2.getId() + "," + c2.getName() + "," + c2.getAge());
    }

    //copy方法实现了对Customer对象的拷贝操作
    public Object copy(Object object) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取object对象的class对象
        Class<?> classType = object.getClass();
        System.out.println(classType);
        System.out.println(classType.getName());
        System.out.println("---------------------");
        /**带参数必须用Constructor方法
        Constructor<?> cons = classType.getConstructor();
        Object object = cons.newInstance();
        //上面两行等于下面一行，下面这种不带参数
        //Object object = classType.newInstance();
        System.out.println(object);
         */

        /*
        Constructor<?> cons = classType.getConstructor(String.class,int.class);
        Object object = cons.newInstance("hello",2);
        System.out.println(object);
        */
        //返回object对象的Constructor对象所表示的类的新实例，相当于一个新的对象，类似于object对象的镜像
        Object objectCopy = classType.getConstructor().newInstance();
        //获得object对象的所有成员变量
        Field[] fields = classType.getDeclaredFields();
        /*Method[] methods = classType.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            System.out.println("方法名："+name);
            Method getMethod = classType.getMethod("");
            Method setMethod = classType.getMethod();
            Object value = getMethod.invoke(object);
            setMethod.invoke(objectCopy,value);
        }*/
        for (Field field:fields){
            String name = field.getName();
            System.out.println("变量名："+name);
            //将属性的首字母转换为大写，获取方法名
            String firstname = name.substring(0,1).toUpperCase();
            //get和set加上变量大写首字母和小写的剩余字母就是get和set方法名
            String getMethodName = "get" + firstname + name.substring(1);
            String setMethodName = "set" + firstname + name.substring(1);
            //System.out.println(name.substring(0,1).toUpperCase());
            //System.out.println(name.substring(1));
            System.out.println(getMethodName +"," +setMethodName);
            System.out.println("---------------------");
            //通过反射获取object对象的方法的对象
            Method getMethod = classType.getMethod(getMethodName);
            Method setMethod = classType.getMethod(setMethodName,field.getType());
            //get和set方法获取对象值,invoke在具有指定参数的方法对象上调用此方法对象表示的基础方法
            //value相当于object对象的get方法对象
            Object value = getMethod.invoke(object);
            //通过object的set方法对象设置objectCopy对象的值为get方法对象
            setMethod.invoke(objectCopy,value);
        }
        //最终将obj对象复制到objectCopy对象
        return objectCopy;
    }
}

class Customer {
    private long id;
    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String name, int age) {
        //this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}