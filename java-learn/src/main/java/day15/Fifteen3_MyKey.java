package src.main.java.day15;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ������Կ�ļ�
 */
public class Fifteen3_MyKey {
    public static void main(String[] args) throws IOException {
        //File f = new File("D:/java��Ŀ/java-learn/src/main/java/day15/key.key");
        FileOutputStream fos = new FileOutputStream(
                "D:/java��Ŀ/java-learn/src/main/java/day15/key.key");
        for (int i = 0; i < 128; i++) {
            fos.write((int)(Math.random() * 128));
        }
    }
}
