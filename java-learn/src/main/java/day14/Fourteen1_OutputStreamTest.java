package src.main.java.day14;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Fourteen1_OutputStreamTest {
//�½��ļ���д���ַ���
	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream(
				"D:/java��Ŀ/java-learn/src/main/java/day14/1.txt",true);
		//FileOutputStream��appendΪtrue��ʱ��д����׷�Ӳ��Ḳ��
		os.write("ssssssss".getBytes());
		os.close();
	}
}
