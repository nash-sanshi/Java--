package src.main.java.day14;

import java.io.*;

public class Fourteen3_DateOutputStreamTest1 {

	public static void main(String[] args) throws Exception {
		//���������ʹӦ�ó����Ա�Яʽ��ʽ��ԭʼJava��������д���������
		// Ȼ��Ӧ�ó������ʹ����������������ȡ���ݡ�
		DataOutputStream dos = new DataOutputStream
				(new BufferedOutputStream(new FileOutputStream(
						"D:/java��Ŀ/java-learn/src/main/java/day14/3.txt")));
		byte b = 3;
		int i = 12;
		char ch = 'a';
		float f = 3.3f;
		dos.writeByte(b);
		dos.writeInt(i);
		dos.writeChar(ch);
		dos.writeFloat(f);
		dos.close();
		DataInputStream dis = new DataInputStream
				(new BufferedInputStream(new FileInputStream(
						"D:/java��Ŀ/java-learn/src/main/java/day14/3.txt")));
		//����д˳��Ҫ����һ��
		System.out.println(dis.readByte());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readFloat());
		dis.close();
	}
}
