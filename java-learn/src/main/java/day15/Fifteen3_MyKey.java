package src.main.java.day15;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 生成秘钥文件
 */
public class Fifteen3_MyKey {
    public static void main(String[] args) throws IOException {
        //File f = new File("D:/java项目/java-learn/src/main/java/day15/key.key");
        FileOutputStream fos = new FileOutputStream(
                "D:/java项目/java-learn/src/main/java/day15/key.key");
        for (int i = 0; i < 128; i++) {
            fos.write((int)(Math.random() * 128));
        }
    }
}
