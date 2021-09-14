package src.main.java.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fifteen2_MyEncryp {
    public static void main(String[] args) throws IOException {
        //File inFile = new File("D:/java项目/java-learn/src/main/java/day15/2.txt");
        //File outFile = new File("D:/java项目/java-learn/src/main/java/day15/3.txt");
        FileInputStream fis = new FileInputStream(
                "D:/java项目/java-learn/src/main/java/day15/2.txt");
        FileOutputStream fos = new FileOutputStream(
                "D:/java项目/java-learn/src/main/java/day15/3.txt");
        int length = fis.available();
        System.out.println(fis.available());//长度
        for (int i = 0; i < length; i++) {
            fos.write(fis.read() + i%100);//加100是为了加密，解密的时候要减100
            //对100取模是防止字节超出255后乱码
        }

        //File f = new File("D:/java项目/java-learn/src/main/java/day15/3.txt");
        FileInputStream fis1 = new FileInputStream(
                "D:/java项目/java-learn/src/main/java/day15/3.txt");
        int length1 = fis1.available();
        System.out.println(fis1.available());//字节数
        for (int i = 0; i < length1; i++) {
        //for (int i = 0; i < fis1.available(); i++) {
            System.out.print((char) (fis1.read() - i%100));
        }
        //下面这种方法是较为常用的，但是没办法加密，固定格式的
        /*int len;// 存储读入数组的长度
        byte[] words = new byte[1024];
        while ((len = fis1.read(words)) != -1) {
            System.out.println(fis1.available());
            System.out.print(new String(words, 0, len));
        }*/
    }
}
