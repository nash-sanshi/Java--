package src.main.java.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fifteen2_MyEncryp {
    public static void main(String[] args) throws IOException {
        //File inFile = new File("D:/java��Ŀ/java-learn/src/main/java/day15/2.txt");
        //File outFile = new File("D:/java��Ŀ/java-learn/src/main/java/day15/3.txt");
        FileInputStream fis = new FileInputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/2.txt");
        FileOutputStream fos = new FileOutputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/3.txt");
        int length = fis.available();
        System.out.println(fis.available());//����
        for (int i = 0; i < length; i++) {
            fos.write(fis.read() + i%100);//��100��Ϊ�˼��ܣ����ܵ�ʱ��Ҫ��100
            //��100ȡģ�Ƿ�ֹ�ֽڳ���255������
        }

        //File f = new File("D:/java��Ŀ/java-learn/src/main/java/day15/3.txt");
        FileInputStream fis1 = new FileInputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/3.txt");
        int length1 = fis1.available();
        System.out.println(fis1.available());//�ֽ���
        for (int i = 0; i < length1; i++) {
        //for (int i = 0; i < fis1.available(); i++) {
            System.out.print((char) (fis1.read() - i%100));
        }
        //�������ַ����ǽ�Ϊ���õģ�����û�취���ܣ��̶���ʽ��
        /*int len;// �洢��������ĳ���
        byte[] words = new byte[1024];
        while ((len = fis1.read(words)) != -1) {
            System.out.println(fis1.available());
            System.out.print(new String(words, 0, len));
        }*/
    }
}
