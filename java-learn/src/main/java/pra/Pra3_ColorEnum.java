package src.main.java.pra;

public class Pra3_ColorEnum {
    public static void main(String[] args) {
        for (Color color : Color.values()) {
            System.out.println(color);
        }
    }

    public enum Color{
        RED,BLUE,YELLO
    }
}
