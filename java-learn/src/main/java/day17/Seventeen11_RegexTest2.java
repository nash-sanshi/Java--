package src.main.java.day17;

public class Seventeen11_RegexTest2 {
    public static void main(String[] args) {
        regex();
    }

    public static void regex() {
        String str = "aoz";
        String reg = "ao?z";//?ƥ��ǰ����ӱ��ʽ��λ�һ��
        boolean b = str.matches(reg);
        System.out.println(str + ":" + b);
    }
}
