package src.main.java.pra;

public class ArrayTest {
    public static void main(String[] args) {
    int [] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
