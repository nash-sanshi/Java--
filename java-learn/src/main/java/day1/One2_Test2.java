package src.main.java.day1;

public class One2_Test2 {
    public static void main(String[] args) {
        //位运算
        //0000 0010
        //0001 0000 ->16
        System.out.println(2<<3);
        System.out.println(16>>3);
        //三目运算
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = a>b ? c:d;
        System.out.println(e);
    }
}
