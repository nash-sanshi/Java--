package src.main.java.day15;

import java.io.*;

public class Fifteen1_SerializbleTest1 {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person(20,"zhangsan",4.5);
        Person p2 = new Person(40,"lisi",3.5);
        Person p3 = new Person(30,"wangwu",2.5);
        //�ļ�����������ڽ�����д�뵽�����File��һ��FileDescriptor ��
        FileOutputStream fos = new FileOutputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/1.txt");
        //ObjectOutputStream��Java�����ԭʼ�������ͺ�ͼ��д��OutputStream��
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.writeObject(p3);
        oos.close();
        System.out.println("-----------------------------");
        FileInputStream fis = new FileInputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/1.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        /*for (int i = 0; i < 3; i++) {
            Person p = (Person) ois.readObject();
            System.out.println(p.age+","+p.name+","+p.height);
        }*/
        while (true) {
            try {
                Person p = (Person) ois.readObject();
                System.out.println(p.age + "," + p.name + "," + p.height);
            } catch (Exception e) {
                break;
            }
        }
    }
}

class Person implements Serializable{
    int age;
    String name;
    double height;

    public Person(int age, String name, double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }
}