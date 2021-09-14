package src.main.java.pra.old;

public class JuxingTest {
    public static void main(String[] args) {
        draw(2,2);
        draw(4,5);
    }

    public static void draw(int a, int b){
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
