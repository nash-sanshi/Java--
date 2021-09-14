package src.main.java.day13.io;

import java.io.File;
import java.util.ArrayList;

public class Thirteen5_ListArrayTest {
	//�����ж�Ŀ¼�����ļ������ڵĲ��
	private static int time;

	public static void deepList(File f) {
		//f��һ����ͨ�ļ�������һ����Ŀ¼
		/*if (f.isFile() || f.listFiles().length == 0) {
			return;
		}*/
			File[] files = f.listFiles();
			files = sort(files);
			for (File file : files) {
				StringBuffer output = new StringBuffer();
				if (file.isFile()) {
					output.append(getTabs(time));
					output.append(file.getName());
				} else {
					output.append(getTabs(time));
					output.append(file.getName());
					output.append("\\");
				}
				System.out.println(output);
				if (file.isDirectory()) {
					time++;
					deepList(file);
					time--;
				}
			}

	}

	private static String getTabs(int time) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < time; i++) {
			buffer.append("\t");
		}
		return buffer.toString();
	}
	
	//�����ļ����飬ʹ��Ŀ¼�����ļ�֮ǰ
	private static File[] sort(File[] files) {
		ArrayList<File> sorted = new ArrayList<>();
		//Ѱ������Ŀ¼
		for (File f : files) {
			if (f.isDirectory()) {
				sorted.add(f);
			}
		}
		//Ѱ�������ļ�
		for (File f : files) {
			if (f.isFile()) {
				sorted.add(f);
			}
		}
		//����ת����
		//return sorted.toArray(new File[files.length]);
		return sorted.toArray(new File[0]);
	}

	public static void main(String[] args) {
		File f = new File("D:/java��Ŀ/java-learn/src/main/java/");
		deepList(f);
	}
}
