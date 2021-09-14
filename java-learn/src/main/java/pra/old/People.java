package src.main.java.pra.old;

public class People {
    int age = 20;
    public void change(People c){
        c.age = 30;
    }



    public static void main(String[] args) {
        People p = new People();
        System.out.println(p.age);

        People p2 = new People();
        p2.change(p2);
        System.out.println(p2.age);
    }
}
