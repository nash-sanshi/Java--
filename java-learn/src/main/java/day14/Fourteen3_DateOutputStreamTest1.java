package src.main.java.day14;

import java.io.*;

public class Fourteen3_DateOutputStreamTest1 {

	public static void main(String[] args) throws Exception {
		//数据输出流使应用程序以便携式方式将原始Java数据类型写入输出流。
		// 然后应用程序可以使用数据输入流来读取数据。
		DataOutputStream dos = new DataOutputStream
				(new BufferedOutputStream(new FileOutputStream(
						"D:/java项目/java-learn/src/main/java/day14/3.txt")));
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
						"D:/java项目/java-learn/src/main/java/day14/3.txt")));
		//读和写顺序要保持一致
		System.out.println(dis.readByte());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readFloat());
		dis.close();
	}
}
