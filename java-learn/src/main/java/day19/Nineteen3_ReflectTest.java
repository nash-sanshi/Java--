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

    //copy����ʵ���˶�Customer����Ŀ�������
    public Object copy(Object object) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //��ȡobject�����class����
        Class<?> classType = object.getClass();
        System.out.println(classType);
        System.out.println(classType.getName());
        System.out.println("---------------------");
        /**������������Constructor����
        Constructor<?> cons = classType.getConstructor();
        Object object = cons.newInstance();
        //�������е�������һ�У��������ֲ�������
        //Object object = classType.newInstance();
        System.out.println(object);
         */

        /*
        Constructor<?> cons = classType.getConstructor(String.class,int.class);
        Object object = cons.newInstance("hello",2);
        System.out.println(object);
        */
        //����object�����Constructor��������ʾ�������ʵ�����൱��һ���µĶ���������object����ľ���
        Object objectCopy = classType.getConstructor().newInstance();
        //���object��������г�Ա����
        Field[] fields = classType.getDeclaredFields();
        /*Method[] methods = classType.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            System.out.println("��������"+name);
            Method getMethod = classType.getMethod("");
            Method setMethod = classType.getMethod();
            Object value = getMethod.invoke(object);
            setMethod.invoke(objectCopy,value);
        }*/
        for (Field field:fields){
            String name = field.getName();
            System.out.println("��������"+name);
            //�����Ե�����ĸת��Ϊ��д����ȡ������
            String firstname = name.substring(0,1).toUpperCase();
            //get��set���ϱ�����д����ĸ��Сд��ʣ����ĸ����get��set������
            String getMethodName = "get" + firstname + name.substring(1);
            String setMethodName = "set" + firstname + name.substring(1);
            //System.out.println(name.substring(0,1).toUpperCase());
            //System.out.println(name.substring(1));
            System.out.println(getMethodName +"," +setMethodName);
            System.out.println("---------------------");
            //ͨ�������ȡobject����ķ����Ķ���
            Method getMethod = classType.getMethod(getMethodName);
            Method setMethod = classType.getMethod(setMethodName,field.getType());
            //get��set������ȡ����ֵ,invoke�ھ���ָ�������ķ��������ϵ��ô˷��������ʾ�Ļ�������
            //value�൱��object�����get��������
            Object value = getMethod.invoke(object);
            //ͨ��object��set������������objectCopy�����ֵΪget��������
            setMethod.invoke(objectCopy,value);
        }
        //���ս�obj�����Ƶ�objectCopy����
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