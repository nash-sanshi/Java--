package src.main.java.pra.old;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class HashSetT {
    public static void main(String[] args) {
        HashSet<String> a = new HashSet<>();
        a.add("a");
        a.add("b");
        a.add("c");
        for (Iterator<String> iterator = a.iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            System.out.println(next);
        }

        //Person相当于一个类型
        HashSet<Person> b = new HashSet<>();
        b.add(new Person("zhangsan", 20, "nantong"));
        for (Iterator<Person> iterator = b.iterator(); iterator.hasNext(); ) {
            Person next =  iterator.next();
            System.out.println(next.getName());
            System.out.println(next.getAge());
            System.out.println(next.getAddrss());
        }
    }
}

class Person{
    private String name;
    private int age;
    private String addrss;

    public Person(String name, int age, String addrss) {
        this.name = name;
        this.age = age;
        this.addrss = addrss;
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

    public String getAddrss() {
        return addrss;
    }

    public void setAddrss(String addrss) {
        this.addrss = addrss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(addrss, person.addrss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, addrss);
    }
}
