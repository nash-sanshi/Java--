package src.main.java.day13.io;

import java.io.File;
import java.util.ArrayList;

public class Thirteen5_ListArrayTest {
	//用于判断目录或者文件所处于的层次
	private static int time;

	public static void deepList(File f) {
		//f是一个普通文件或者是一个空目录
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
	
	//整理文件数组，使得目录排在文件之前
	private static File[] sort(File[] files) {
		ArrayList<File> sorted = new ArrayList<>();
		//寻找所有目录
		for (File f : files) {
			if (f.isDirectory()) {
				sorted.add(f);
			}
		}
		//寻找所有文件
		for (File f : files) {
			if (f.isFile()) {
				sorted.add(f);
			}
		}
		//集合转数组
		//return sorted.toArray(new File[files.length]);
		return sorted.toArray(new File[0]);
	}

	public static void main(String[] args) {
		File f = new File("D:/java项目/java-learn/src/main/java/");
		deepList(f);
	}
}
