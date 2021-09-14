package src.main.java.pra.old;

import java.util.Arrays;

public class GenericArray<T> {
    private T[] a;

    public T[] getA() {
        return a;
    }

    public void setA(T[] a) {
        this.a = a;
    }

    public static void main(String[] args) {
        GenericArray<String> s = new GenericArray<>();
        String[] s1 = {"hello", "world"};
        s.setA(s1);
        System.out.println(Arrays.toString(s.getA()));
        String[] s2 = s.getA();
        for (String value : s2) {
            System.out.println(value);
        }
        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }
    }
}
