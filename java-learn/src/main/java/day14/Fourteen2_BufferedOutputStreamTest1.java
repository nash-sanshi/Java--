package src.main.java.day14;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Fourteen2_BufferedOutputStreamTest1 {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream(
				"D:/java��Ŀ/java-learn/src/main/java/day14/2.txt");
		BufferedOutputStream bos = new BufferedOutputStream(os);
		//BufferedOutputStreamд���ļ�Ĭ�ϻḲ��
		bos.write("https://www.ntrj.cn.c.c.c.c".getBytes());
		bos.close();
		os.close();
	}
}
