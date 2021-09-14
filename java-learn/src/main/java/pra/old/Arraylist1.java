package src.main.java.pra.old;

import java.util.ArrayList;

public class Arraylist1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Point(1,2));
        list.add(new Point(3,4));
        list.add(new Point(5,6));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list);
    }

    public static class Point{
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String toString(){
            return "a=" + this.a + "ºÍb=" + this.b;
        }
    }
}
