package src.main.java.day13.io;

import java.io.File;
import java.io.IOException;

public class Thirteen1_FileTest1 {
	public static void main(String[] args) throws IOException {
	
		File a = new File("D:/java项目/java-learn/src/main/java/day13/io/test.txt");
		//true如果命名文件不存在并被成功创建; false如果命名文件已经存在
		System.out.println(a.createNewFile());

		File b = new File("D:/java项目/java-learn/src/main/java/day13/io/hello");
		//true当且仅当该目录被创建时; false否则
		System.out.println(b.mkdir());
		System.out.println(b.isDirectory());

		System.out.println("----------------------------------------------------");
		File c = new File("D:/java项目");
		//list:返回一个字符串数组，命名由此抽象路径名表示的目录中的文件和目录。
		String[] names = c.list();
		for(String name:names) {
			System.out.println(name);
		}

		System.out.println("----------------------------------------------------");
		File d = new File("D:/java项目/java-learn/src/main/java/day13/io/");
		//listFiles:返回一个抽象路径名数组，表示由该抽象路径名表示的目录中的文件。
		File[] files = d.listFiles();
		for (File file : files) {
			System.out.println(file);
			//System.out.println(file.getName());
		}
	}
}
