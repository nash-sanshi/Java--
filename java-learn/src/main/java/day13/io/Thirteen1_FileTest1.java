package src.main.java.day13.io;

import java.io.File;
import java.io.IOException;

public class Thirteen1_FileTest1 {
	public static void main(String[] args) throws IOException {
	
		File a = new File("D:/java��Ŀ/java-learn/src/main/java/day13/io/test.txt");
		//true��������ļ������ڲ����ɹ�����; false��������ļ��Ѿ�����
		System.out.println(a.createNewFile());

		File b = new File("D:/java��Ŀ/java-learn/src/main/java/day13/io/hello");
		//true���ҽ�����Ŀ¼������ʱ; false����
		System.out.println(b.mkdir());
		System.out.println(b.isDirectory());

		System.out.println("----------------------------------------------------");
		File c = new File("D:/java��Ŀ");
		//list:����һ���ַ������飬�����ɴ˳���·������ʾ��Ŀ¼�е��ļ���Ŀ¼��
		String[] names = c.list();
		for(String name:names) {
			System.out.println(name);
		}

		System.out.println("----------------------------------------------------");
		File d = new File("D:/java��Ŀ/java-learn/src/main/java/day13/io/");
		//listFiles:����һ������·�������飬��ʾ�ɸó���·������ʾ��Ŀ¼�е��ļ���
		File[] files = d.listFiles();
		for (File file : files) {
			System.out.println(file);
			//System.out.println(file.getName());
		}
	}
}
