package src.main.java.pra;

public class Pra1_Exception {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        int c = 0;
        //ctrl+alt+T¿ì½Ý¼ü
        try {
            c = a/b;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ok");
        }

        System.out.println(c);
    }
}
