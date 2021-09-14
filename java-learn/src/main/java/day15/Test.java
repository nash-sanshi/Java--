package src.main.java.day15;

import java.io.FileInputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //解密
        FileInputStream fis = new FileInputStream("D:/test.txt");
        int length = fis.available();
        System.out.println(fis.available());//长度
        //for (int i = 0; i < fis.available(); i++) {
        //for (int i = 0; i < length; i++) {
            //System.out.print((char)(fis.read()));
        //}
        System.out.println("-------------------");
        int len;// 存储读入数组的长度
        byte[] words = new byte[1024];
        while ((len = fis.read(words)) != -1) {
            System.out.println(fis.available());
            System.out.print(new String(words, 0, len));
        }
    }
}
