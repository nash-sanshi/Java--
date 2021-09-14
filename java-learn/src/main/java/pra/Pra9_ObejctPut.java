package src.main.java.pra;

import java.io.*;

public class Pra9_ObejctPut {
    public static void main(String[] args) throws IOException {
        Person p1 = new Person("zhangsan", 20, "nanton");
        Person p2 = new Person("lisi", 30, "nanton");
        Person p3 = new Person("wangwu", 40, "nanton");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/java项目/java-practise/src/test/java/p.txt"));
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.writeObject(p3);
        //oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/java项目/java-practise/src/test/java/p.txt"));
        while (true) {
            try {
                Person p = (Person) ois.readObject();
                System.out.println(p.name+":"+p.age+":"+p.address);
            } catch (Exception e) {
                //e.printStackTrace();
                break;
            }

        }
    }

    public static class Person implements Serializable {
        private String name;
        private int age;
        private String address;

        public Person(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
