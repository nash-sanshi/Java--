package src.main.java.day14;

import java.io.FileInputStream;
import java.io.InputStream;

public class Fourteen0_InputStreamTest1 {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream(
				"D:/java��Ŀ/java-learn/src/main/java/day14/0.txt");
		/**byte[] buffer = new byte[20];
		int length;
		//public int read(byte[] b,int off,int len)throws IOException
		//b - ��ȡ���ݵĻ�������
		//off - Ŀ������ b����ʼƫ����
		//len - ��ȡ������ֽ�����
		while (-1 != (length = is.read(buffer, 0, 20))) {
			String str = new String(buffer, 0, length);
			System.out.println(str);
		}*/
		System.out.println("------------------------");
		byte[] bytes = new byte[1024];
		int len;
		if (-1 != (len = is.read(bytes, 0, bytes.length))) {
			System.out.println(new String(bytes,0,len));
		}
		is.close();
	}
}
