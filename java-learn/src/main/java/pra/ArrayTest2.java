package src.main.java.pra;

public class ArrayTest2 {
    public static void main(String[] args) {
        Poss[] p = new Poss[3];
        p[0] = new Poss(100);
        p[1] = new Poss(200);
        p[2] = new Poss(300);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].a);
            System.out.println(p[i]);
        }
    }
}

class Poss{
    int a;
    public Poss(int a){this.a = a;}
}