package src.main.java.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fifteen4_MyEncryp1 {
    public static void main(String[] args) throws IOException {
        //��ȡ��Կ�ļ�
        int[] key = new int[128];//128�ֽڴ�С����Կ�ļ�
        //File keyFile = new File("D:/java��Ŀ/java-learn/src/main/java/day15/key.key");
        FileInputStream keyFis = new FileInputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/key.key");
        for (int i = 0; i < 128; i++) {
            key[i] = keyFis.read();//�Ӹ���������ȡһ���ֽڵ����ݡ�
        }
        //����
        //File inFile = new File("D:/java��Ŀ/java-learn/src/main/java/day15/2.txt");
        //File outFile = new File("D:/java��Ŀ/java-learn/src/main/java/day15/3.txt");
        FileInputStream fis = new FileInputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/2.txt");
        FileOutputStream fos = new FileOutputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/3.txt");
        int length = fis.available();
        System.out.println(fis.available());//�ֽ���
        for (int i = 0; i < length; i++) {
            fos.write(fis.read() + key[i % 128]);//��128ȡģ����֤ȡ����128����
        }
        //����
        FileInputStream fis1 = new FileInputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/3.txt");
        int length1 = fis1.available();
        System.out.println(fis1.available());//�ֽ���
        for (int i = 0; i < length1; i++) {
            System.out.print((char)(fis1.read()- key[i % 128]));
        }
    }
}

