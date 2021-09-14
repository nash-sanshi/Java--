package src.main.java.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fifteen4_MyEncryp1 {
    public static void main(String[] args) throws IOException {
        //读取秘钥文件
        int[] key = new int[128];//128字节大小的秘钥文件
        //File keyFile = new File("D:/java项目/java-learn/src/main/java/day15/key.key");
        FileInputStream keyFis = new FileInputStream(
                "D:/java项目/java-learn/src/main/java/day15/key.key");
        for (int i = 0; i < 128; i++) {
            key[i] = keyFis.read();//从该输入流读取一个字节的数据。
        }
        //加密
        //File inFile = new File("D:/java项目/java-learn/src/main/java/day15/2.txt");
        //File outFile = new File("D:/java项目/java-learn/src/main/java/day15/3.txt");
        FileInputStream fis = new FileInputStream(
                "D:/java项目/java-learn/src/main/java/day15/2.txt");
        FileOutputStream fos = new FileOutputStream(
                "D:/java项目/java-learn/src/main/java/day15/3.txt");
        int length = fis.available();
        System.out.println(fis.available());//字节数
        for (int i = 0; i < length; i++) {
            fos.write(fis.read() + key[i % 128]);//对128取模，保证取数在128以内
        }
        //解密
        FileInputStream fis1 = new FileInputStream(
                "D:/java项目/java-learn/src/main/java/day15/3.txt");
        int length1 = fis1.available();
        System.out.println(fis1.available());//字节数
        for (int i = 0; i < length1; i++) {
            System.out.print((char)(fis1.read()- key[i % 128]));
        }
    }
}

